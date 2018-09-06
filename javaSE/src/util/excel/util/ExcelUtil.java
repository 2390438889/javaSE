package util.excel.util;


import java.io.File;
import java.util.Date;
import java.util.List;
/**
 * 将实体类集合中的数据入库
 * @author lujie
 * @date 2018-9-1
 *
 */

public class ExcelUtil extends ExcelWrite{

   // private static int i=1;
    public ExcelUtil(File file, Class clazz) {
        super(file, clazz);
        //this.bigchainServer=bigchainServer;
    }

    public ExcelUtil() {
        super(null, null);
    }

    @Override
    public boolean toSql(List list,String private_key) {
        if(list!=null){
            for(Object obj:list){
                System.out.println(obj);
            }
            return true;

        }

        return false;
    }

    @Override
    public void toExcel(List list) {

    }

    @Override
    public Date parseDate(String value) {
        return new Date(value.replace("-","/"));
    }
}
