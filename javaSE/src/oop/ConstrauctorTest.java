package oop;

/**
 * 尽管可以用this调用一个构造器，但却不能调用第二个
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
