package com.sundy.www.gamecore;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;
/**
 * 各种实现方法放在了 Frame这个类里面！
 * @author Administrator
 *
 */
public class Main implements Runnable
{
	public static int whichFrame = 0;
	//public static int whichFrame = 0;

	public static void main(String[] args)
	{

		GameCore.start(new Main());
	}

	@Override
	public void run()
	{
		// 画出开始界面
		new Frame().gameStartFrame();

		//不断监听，判断需要画出那个画面
		while (true)
		{
			// 如果which=1 画出游戏开始的画面
			if (whichFrame == 1)
			{
				new Frame().gameStartFrame();
			}
			
			// 如果which=2 画出吃金币的画面
			else if (whichFrame == 2)
			{
				new Frame().eatCoinFrame(0);
			}
			//如果which=3画出游戏帮助界面
			else if(whichFrame==3)
			{
				new Frame().gameHelpFrame();
			}
		}

	}

}
