package oop;

//��ͨ���Եĳ�ʼ��
class Windows{
	public Windows(int i){
		System.out.println("windows("+i+")");
	}
}
class House{
	int size;
	//������֮ǰ
	Windows windows1=new Windows(1);
	public int getSize(){
		return this.size;
	}
	int height;
	public House(){
		System.out.println("��������ʼ��");
		windows2=new Windows(22);
	}
	//������֮��
	Windows windows2=new Windows(2);
}

//��̬�����ĳ�ʼ��
/**
 * ��֤���Գ�ʼ��
 *
 */
public class AttributeInitTest {
	public static void main(String[] args) {
		//��֤���Գ�ʼ��˳��
		House house=new House();
	}
}
