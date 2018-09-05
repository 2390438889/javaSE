package five;

public class FinaliazeTest {
	private boolean flag=true;
	public FinaliazeTest(boolean flag) {
		this.flag=flag;
	}
	public void checkin() {
		this.flag=false;
	}
	@Override
	protected void finalize() throws Throwable {
		if(flag) {
			System.out.println("进入垃圾回收器");
			super.finalize();
		}
	}
	public static void main(String[] args) {
		
		{
			FinaliazeTest finalazeTest=new FinaliazeTest(true);
		}
		new FinaliazeTest(true);		
		//强制进入终结动作，即进入垃圾回收器
		System.gc();
	}
}
