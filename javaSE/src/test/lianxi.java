package test;
import java.io.File;

import org.junit.Test;

import static util.FileUtil.*;
public class lianxi {
	@Test
	public void copyFileTest(){
		try {
			copyFile(new File("C:\\Users\\Administrator\\Desktop\\就业感想.txt"),new File("C:\\Users\\Administrator\\Desktop\\就业感想.doc"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
