package test1;

public class MethodTest 
{

	public static void main(String[] args)
	{
		TempClass tempclass = new TempClass();
		
		String[] str1 =
		{ "1","2" };
		String[] str2 =
		{ "5","6","7","8" };

		
		String []constr=tempclass.concat(str1, str2);
		
		for (int i = 0; i < constr.length; i++)
		{
			//String string = constr[i];
			System.out.print(constr[i]);
			
		}
	}

}
