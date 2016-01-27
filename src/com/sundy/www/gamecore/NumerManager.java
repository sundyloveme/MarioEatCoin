package com.sundy.www.gamecore;

/**
 * 单例模式
 */
public class NumerManager
{
   private static int num;//编号
   public static  NumerManager instance = new NumerManager();//实例
   
   /**
    * 得到编号
    * @return 返回一个没有使用的编号
    */
   public int getNum()
   {
	   return num++;//防止重复
   }
   
   /**
    * 单例的构造函数
    */
   private NumerManager(){}
   
   
   
}
