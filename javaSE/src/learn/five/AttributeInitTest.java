package learn.five;

import java.util.Arrays;

//��ͨ���Եĳ�ʼ��
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
	//������֮ǰ
	Windows windows1=new Windows("1");
	public int getSize(){
		return this.size;
	}
	int height;
	public House(){
		System.out.println("��������ʼ��");
		windows2=new Windows("2");
	}
	//������֮��
	Windows windows2=new Windows("3");
}

//��̬�����ĳ�ʼ��

class HouseStatic{
	Windows t1=windows.look();
	static Windows windows=new Windows("staic");
	
	public HouseStatic(){
		System.out.println("HouseStatic ��������ʼ����");
	}
	Windows w1=new Windows("w1");
}

/**
 * ϰ��
 * ��ϰ14: (1)��дһ����,ӵ��������̬�ַ�����,����һ���ڶ��崦��ʼ��
 * ,��һ���ھ� ̬���г�ʼ��������,����һ����̬�������Դ�ӡ�������ֶ�ֵ��
 * ��֤�����Ƕ����ڱ�ʹ��֮ǰ��ɳ�ʼ��������
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
 * ϰ��2
 * ����ϰ15: (1)��дһ�������ַ��������,������ʵ����ʼ����ʽ���г�ʼ����
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
 * ��ϰ16: (1)����һ��String��������,��Ϊÿһ��Ԫ�ض���ֵһ��String,��forѭ������ "ӡ�����顣
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
 * ��ϰ17: (2)����һ����,����һ������һ��String�����Ĺ��������ڹ���׶�,��ӡ�ò���������һ������Ķ�����������,
 * ���ǲ�ʵ��ȥ��������ֵ�������顣�����г���ʱ,�� ע�����ԶԸù������ĵ����еĳ�ʼ����Ϣ�Ƿ��ӡ�˳�����
 * ��ϰ18: (1)ͨ����������ֵ����������,�Ӷ����ǰһ����ϰ��
 */

class Page_101_17{
	public Page_101_17(String msg){
		System.out.print("Constructor("+msg+")");
	}
	public static void main(String[] args){
		Page_101_17[] page_101_17s=new Page_101_17[10];
		System.out.print("��ֵǰ��");
		for(Page_101_17 page_101_17:page_101_17s){
			System.out.print(page_101_17+" ");
		}
		System.out.println();
		System.out.print("��ֵ��");
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
 *�ɱ�����б�
 */
class Page_103{
	public static void run(Object... objs){
		System.out.println(Arrays.toString(objs));
	}
}
/**
 * ��֤���Գ�ʼ��
 *
 */
public class AttributeInitTest {
	//main�����������ͱ���ΪString����
	public static void main(String... objs) {
		System.out.println(Arrays.toString(objs));
		//��֤���Գ�ʼ��˳��
		House house=new House();
		System.out.println("=============================================��");
		//��֤��̬������ʼ��
		HouseStatic houseStatic=new HouseStatic();
		
		System.out.println("=============================================��");
		//ϰ��1
		StaticTest.look();
		
		System.out.println("=============================================��");
		//ϰ��2
		AttributeTest attributeTest=new AttributeTest();
		
		System.out.println("=============================================��");
		//Page.101
		Page_101_16.main(new String[]{"My","name","is","lujie","!"});
		System.out.println();
		System.out.println("=============================================��");
		//Page.101
		Page_101_17.main(new String[]{});
		
		System.out.println("=============================================��");
		//Page.103
		Page_103.run(1,2,3.0,"aa");
		Page_103.run();
	}
}
