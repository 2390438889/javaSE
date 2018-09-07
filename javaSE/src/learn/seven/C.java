package learn.seven;

public class C extends A {
	private B b=new B();
	public C(){
		System.out.println("Contractor C() >>>");
	}
	public C(String str){
		super(str);
		System.out.println("Contractor C("+str+") >>>");
	}
	public static void main(String[] args) {
		new C("11");
		new C("str");
	}
}
