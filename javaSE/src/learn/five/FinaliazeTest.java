package learn.five;

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
			System.out.println("��������������");
			super.finalize();
		}
	}
	public static void main(String[] args) {
		
		{
			FinaliazeTest finalazeTest=new FinaliazeTest(true);
		}
		new FinaliazeTest(true);		
		//ǿ�ƽ����սᶯ��������������������
		System.gc();
	}
}
