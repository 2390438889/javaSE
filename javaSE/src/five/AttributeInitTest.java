package five;

import java.util.Arrays;

//普通属性的初始化
class Windows{
	String msg;
	public Windows(String i){
		this.msg=i;
		System.out.println("windows("+i+")");
	}
	public Windows look(){
		System.out.println("look("+msg+")");
		return this;
	}
}
class House{
	int size;
	//构造器之前
	Windows windows1=new Windows("1");
	public int getSize(){
		return this.size;
	}
	int height;
	public House(){
		System.out.println("构造器初始化");
		windows2=new Windows("2");
	}
	//构造器之后
	Windows windows2=new Windows("3");
}

//静态变量的初始化

class HouseStatic{
	Windows t1=windows.look();
	static Windows windows=new Windows("staic");
	
	public HouseStatic(){
		System.out.println("HouseStatic 构造器初始化！");
	}
	Windows w1=new Windows("w1");
}

/**
 * 习题
 * 练习14: (1)编写一个类,拥有两个静态字符串域,其中一个在定义处初始化
 * ,另一个在静 态块中初始化。现在,加入一个静态方法用以打印出两个字段值。
 * 请证明它们都会在被使用之前完成初始化动作。
 */

class StaticTest{

	static Windows s2;
	
	static Windows s1=new Windows("static(1)");
	static{
		s2=new Windows("static(2)");
	}
	static void look(){
		s1.look();
		s2.look();
	}
}

/**
 * 习题2
 * ·练习15: (1)编写一个含有字符串域的类,并采用实例初始化方式进行初始化。
 */
class AttributeTest{
	Windows s1;
	Windows s2;
	{
		s1=new Windows("attribute1");
		s2=new Windows("attribute2");
	}
	public AttributeTest(){
		System.out.println("s1 and s2 init");
	}
}

/**
 * Page.101
 * 练习16: (1)创建一个String对象数据,并为每一个元素都赋值一个String,用for循环来打 "印该数组。
 */
class Page_101_16{
	public static void main(String[] args) {
		for(String str:args){
			System.out.print(str+" ");
		}
	}
}

/**
 * Page.101
 * 练习17: (2)创建一个类,它有一个接受一个String参数的构造器。在构造阶段,打印该参数。创建一个该类的对象引用数组,
 * 但是不实际去创建对象赋值给该数组。当运行程序时,请 注意来自对该构造器的调用中的初始化消息是否打印了出来。
 * 练习18: (1)通过创建对象赋值给引用数组,从而完成前一个练习。
 */

class Page_101_17{
	public Page_101_17(String msg){
		System.out.print("Constructor("+msg+")");
	}
	public static void main(String[] args){
		Page_101_17[] page_101_17s=new Page_101_17[10];
		System.out.print("赋值前：");
		for(Page_101_17 page_101_17:page_101_17s){
			System.out.print(page_101_17+" ");
		}
		System.out.println();
		System.out.print("赋值后：");
		for(int i=0;i<page_101_17s.length;i++){
			page_101_17s[i]=new Page_101_17(i+"");
		}
		for(Page_101_17 page_101_17:page_101_17s){
			System.out.print(page_101_17+" ");
		}
		System.out.println();
	}	
}


/**
 * Page.103
 *可变参数列表
 */
class Page_103{
	public static void run(Object... objs){
		System.out.println(Arrays.toString(objs));
	}
}
/**
 * 验证属性初始化
 *
 */
public class AttributeInitTest {
	//main方法参数类型必须为String类型
	public static void main(String... objs) {
		System.out.println(Arrays.toString(objs));
		//验证属性初始化顺序
		House house=new House();
		System.out.println("=============================================》");
		//验证静态变量初始化
		HouseStatic houseStatic=new HouseStatic();
		
		System.out.println("=============================================》");
		//习题1
		StaticTest.look();
		
		System.out.println("=============================================》");
		//习题2
		AttributeTest attributeTest=new AttributeTest();
		
		System.out.println("=============================================》");
		//Page.101
		Page_101_16.main(new String[]{"My","name","is","lujie","!"});
		System.out.println();
		System.out.println("=============================================》");
		//Page.101
		Page_101_17.main(new String[]{});
		
		System.out.println("=============================================》");
		//Page.103
		Page_103.run(1,2,3.0,"aa");
		Page_103.run();
	}
}
