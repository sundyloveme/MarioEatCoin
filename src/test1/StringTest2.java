package test1;

import java.awt.Color;

import com.rupeng.game.GameCore;

public class StringTest2 
{
	/**
	 * ÇóºÍ
	 * @param num
	 * @return
	 */
	public static int sum(int... num)
	{
		int sum=0;
		for (int i = 0; i < num.length; i++)
		{
			sum+=num[i];
			
		}
		return sum;
	}
	
//	public static int sum1(int [] num)
//	{
//		int sum=0;
//		for (int i = 0; i < num.length; i++)
//		{
//			sum+=num[i];
//			
//		}
//		return sum;
//	}
	
	public static void main(String[] args)
	{
		System.out.println(sum(1,2,3,4));
		
		
	}

}
