package test1;
//一个临时的类，用来存放一些惯用的方法
//2016年1月20日15:57:35
public class TempClass
{
    //实现合并两个字符串数组
	//返回合并的字符串数组
	String [] concat(String s1[],String s2[])
	{
		String []conStr =new String[s1.length+s2.length];
		
		for (int i = 0; i < s1.length; i++)
		{
			//String string = s1[i];
			conStr[i]=s1[i];
		}
		
		for (int i = 0; i < s2.length; i++)
		{
			//String string = conStr[i];
			conStr[s1.length+i]=s2[i];
			
		}		
		return conStr;
	}
	
	
	
}
