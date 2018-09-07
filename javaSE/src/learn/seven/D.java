package learn.seven;

public class D extends A{
	private A a=new A("我是字段");
	private B b=new B();
	public D(){
		System.out.println("Constrctor D()");
	}
	public D(String msg){
		super("我是父类");
		System.out.println("Constrctor D("+msg+")");
	}
	public static void main(String[] args) {
		new D();
		new D("str");
	}
}
