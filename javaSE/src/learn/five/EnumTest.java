package learn.five;

/**
 * page.107
 * ��ϰ21: (1)����һ��enum,������ֽ������С��ֵ��6�����͡�ͨ��values()ѭ������ӡÿ,һ��ֵ����ordinal,
 * ��ϰ22: (2)��ǰ���������,Ϊenumдһ��switch���,����ÿһ��case,������ض����ҵ�������
 */
enum Money{
	ONE,FIVE,TEN,TWENTY,FIFTY,ONEHUNDRED
}
public class EnumTest {
	public static void main(String[] args) {
		for(Money money:Money.values()){
			System.out.print("value:"+money);
			System.out.println("\tordinal:"+money.ordinal());
		}
	}
}
