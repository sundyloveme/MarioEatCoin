package com.sundy.www.gamecore;
import java.awt.Color;

import com.rupeng.game.GameCore;

public class Text
{
	private int num = NumerManager.instance.getNum();// 文字的编号

	/**
	 * 构造函数
	 * @param text 显示的文字
	 * @param px x坐标
	 * @param py y坐标
	 * @param color 文字的颜色
	 * @param TextFontSize 文字的尺寸
	 */
	public Text(String text,int px,int py,Color color,int TextFontSize)
	{
		GameCore.createText(num, text);
		GameCore.setTextFontSize(num, TextFontSize);
		GameCore.setTextPosition(num, px, py);
		GameCore.setTextColor(num, color);
	}
	
	/**
	 * 构造函数 
	 * @param text 显示的文字
	 */
	public Text(String text)
	{
		GameCore.createText(num, text);
	}
	
	/**
	 * 返回文字的编号
	 * @return
	 */
	public int getNum()
	{
		return num;
	}
	
	/**
	 * 文字消失
	 */
	public void hideText()
	{
		GameCore.setText(num, "");
	}
}
