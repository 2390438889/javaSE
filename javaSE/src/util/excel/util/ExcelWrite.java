package util.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.excel.annocation.ExcelCell;
import util.excel.annocation.ExcelSheet;

/**
 * 将excel表数据解析为实体类集合
 * @author lujie
 * @date 2018-9-1
 *
 */
public abstract class ExcelWrite {
    protected File excelFile;
    protected Class clazz;
    private Workbook workbook;
    private int sheets;
    private int initRow;
    private Map<String,Field> fieldsMap;
    private Map<Field,String> cellsMap;
    private Map<Integer,String> numsMap;
    private Map<Field,String> methods;

    public ExcelWrite(File file,Class clazz){
        this.excelFile=file;
        this.clazz=clazz;
        this.sheets=-1;
        init();
    }

    //初始化
    private void init(){
        sheets=-1;
        ExcelSheet excelSheet= (ExcelSheet) clazz.getAnnotation(ExcelSheet.class);
        ExcelCell excelCell;


        if(excelSheet!=null){
            initRow=excelSheet.initRow();
            fieldsMap=new HashMap<>();
            cellsMap=new HashMap<>();
            numsMap=new HashMap<>();
            methods=new HashMap<>();
            sheets=excelSheet.value();
            try  {
                FileInputStream fis = new FileInputStream(excelFile);
                //初始化Excel表对象
                if(excelFile.getName().endsWith(".xls")){
                    workbook=new HSSFWorkbook(fis);
                }else if(excelFile.getName().endsWith(".xlsx")){
                    workbook=new XSSFWorkbook(fis);
                }else{
                    throw new Exception("文件格式有误，只能为.xls/.xlsx文件");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //初始化单元格序号
            Sheet sheet=workbook.getSheetAt(sheets);
            Map<String,Integer> tempMap=new HashMap<>();
            Row row=sheet.getRow(initRow);
            for(int j=0;j<row.getLastCellNum();j++){
                Cell cell=row.getCell(j);
                numsMap.put(j,cell.getStringCellValue());
                tempMap.put(cell.getStringCellValue(),j);

            }
            int i=0;
            for(Field field:clazz.getDeclaredFields()){
                excelCell=field.getAnnotation(ExcelCell.class);
                if(excelCell!=null){
                    //验证excel表格内的字段是否和实体类匹配
                    if(tempMap.get(excelCell.colName())==null){
                        sheets=-1;
                        System.out.println("实体类不匹配！");
                        return ;
                    }
                    fieldsMap.put(excelCell.colName(),field);
                    cellsMap.put(field,excelCell.colName());
                    methods.put(field,field.getName().substring(0,1).toUpperCase()+field.getName().substring(1));
                }
            }





        }
    }
    public abstract boolean toSql(List list,String private_key);

    public abstract void toExcel(List list);

    //读取Excel中的数据
    public List readExcel() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if(sheets>-1){
            List list=new ArrayList();
            Method method;
            Row row;
            Cell cell;
            Sheet sheet=workbook.getSheetAt(sheets);
            for(int k=initRow+1;k<sheet.getLastRowNum();k++){
                row=sheet.getRow(k);
                Object obj=clazz.newInstance();
                for(int j=0;j<row.getLastCellNum();j++){
                    //获得该序号列名
                    String cellName=numsMap.get(j);
                    cell=row.getCell(j);
                    //获得列名对应的字段
                    Field field=fieldsMap.get(cellName);
                    if(field!=null){
                        //将值存到对应的字段中
                        method=clazz.getDeclaredMethod("set"+methods.get(field),new Class[]{field.getType()});
                        //如果字段类型为Date类型
                        if(field.getType().getName().endsWith("Date")){
                            method.invoke(obj,parseDate(cell.getStringCellValue()));
                        }else if(field.getType()==String.class){
                            method.invoke(obj,cell.getStringCellValue());
                        }else{
                            method.invoke(obj,field.getType().cast(cell.getNumericCellValue()));
                        }
                    }

                }
                list.add(obj);
            }
            return list;
        }
        return null;
    }

    public abstract Date parseDate(String value);

    public boolean readStart(String private_key){
        try {
            List list=readExcel();
            return toSql(list,private_key);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

}
