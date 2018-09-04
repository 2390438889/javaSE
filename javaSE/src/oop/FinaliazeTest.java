package oop;

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
		new FinaliazeTest(true).checkin();
		
		new FinaliazeTest(true).checkin();
		
		//ǿ�ƽ����սᶯ��������������������
		System.gc();
	}
}
