package learn.seven;

public class A {
	private String msg;
	
	public A(){
		System.out.println("Contractor A() >>>");
	}
	public A(String str){
		msg=str;
		System.out.println("Contractor A("+str+") >>>");
	}
}
