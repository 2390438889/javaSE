package util.alias;

public class Print {
	/**
	 * 在控制台打印不换行，后面加空格
	 * @param obj
	 */
	public static void  print(Object obj){
		System.out.print(obj+" ");
	}
	
	/**
	 * 在控制台打印不换行,后面加指定字符
	 * @param obj	需要打印的字符串
	 * @param split	最后加的分隔符
	 */
	public static void  print(Object obj,String split){
		System.out.print(obj+split);
	}
	
	/**
	 * 在控制台打印后换行
	 * @param obj
	 */
	public static void println(Object obj){
		System.out.println(obj);
	}
}
