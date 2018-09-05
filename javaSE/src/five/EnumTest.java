package five;

/**
 * page.107
 * 练习21: (1)创建一个enum,它包含纸币中最小面值的6种类型。通过values()循环并打印每,一个值及其ordinal,
 * 练习22: (2)在前面的例子中,为enum写一个switch语句,对于每一个case,输出该特定货币的描述。
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
