package oop;

//普通属性的初始化
class Windows{
	public Windows(int i){
		System.out.println("windows("+i+")");
	}
}
class House{
	int size;
	//构造器之前
	Windows windows1=new Windows(1);
	public int getSize(){
		return this.size;
	}
	int height;
	public House(){
		System.out.println("构造器初始化");
		windows2=new Windows(22);
	}
	//构造器之后
	Windows windows2=new Windows(2);
}

//静态变量的初始化
/**
 * 验证属性初始化
 *
 */
public class AttributeInitTest {
	public static void main(String[] args) {
		//验证属性初始化顺序
		House house=new House();
	}
}
