package learn.five;

/**
 * ���ܿ�����this����һ������������ȴ���ܵ��õڶ���
 * @author Administrator
 *
 */
public class ConstrauctorTest {
	public ConstrauctorTest() {
		System.out.println("hello");
	}
	
	public ConstrauctorTest(String str) {
		System.out.println("hello");
	}
	
	public ConstrauctorTest(int i) {
		this();
		// this("aaa");
		System.out.print("value="+i);
		
	}
}
