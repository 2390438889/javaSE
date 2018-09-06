package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件工具类
 * @author Administrator
 *
 */
public class FileUtil {
	private FileUtil(){}
	/**
	 * 将源文件目录备份到备份文件目录中
	 * @param in 源文件目录
	 * @param out 目标文件目录
	 * @throws Exception
	 */
    public static final void copyDir(File in,File out) throws Exception {

        if(in.isDirectory()){
            //创建文件夹
            File dir=new File(out,in.getName());
            if(!dir.exists()){
                dir.mkdir();
            }
            //遍历文件夹
            for(File file:in.listFiles()){
                copyDir(dir,file);
            }
        }else{
            if(in.exists()&&out.isDirectory()){
                //备份文件
                File file=new File(out,in.getName());
                copyFile(in,file);
            }
        }



    }
    
    /**
     * 拷贝文件
     * @param in	源文件
     * @param out	目标文件
     * @return
     * @throws Exception
     */
    public static final boolean copyFile(File in, File out) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(in);
            FileOutputStream fos = new FileOutputStream(out);
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
            fis.close();
            fos.close();
            return true;
        } catch (IOException ie) {
            ie.printStackTrace();
            return false;
        }
    }
    
    /**
     * 拷贝文件
     * @param inPath	源文件路径
     * @param outPath	目标文件路径
     * @return
     * @throws Exception
     */
    public static final boolean copyFile(String inPath, String outPath) throws Exception {
        try {
            File in = new File(inPath);
            File out = new File(outPath);
            return copyFile(in, out);
        } catch (IOException ie) {
            ie.printStackTrace();
            return false;
        }

    }
    
    /**
     * 移动文件
     * @param in	源文件对象
     * @param out	目标文件对象
     * @return
     */
    public static final boolean moveFile(File in,File out){
    	try {
    		//拷贝文件
			if(copyFile(in,out)){
				//删除文件
				if(in.delete()){
					return true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    
    /**
     * 递归删除文件
     * @param file 需要删除的文件对象
     */
    public static final void deleteFile(File file){
        if(file.isDirectory()){
            //遍历文件夹
            for(File f:file.listFiles()){
            	deleteFile(f);
            }
            file.delete();
        }else{
            file.delete();
        }
    }
}
