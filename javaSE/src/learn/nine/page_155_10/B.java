package learn.nine.page_155_10;

public class B extends A{
	@Override
	public void runB() {
		System.out.println("B.runB()");
	}
	public static void main(String[] args) {
		A a=new B();
		a.runA();
	}
}
