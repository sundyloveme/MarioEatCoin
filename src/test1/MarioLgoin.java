package test1;
//定义超级玛丽开始界面这个类
//封装了很多常用的方法
import java.awt.Color;

import com.rupeng.game.GameCore;

public class MarioLgoin implements Runnable
{

	@Override
	public void run()
	{
		
//开始界面 文字的显示
		GameCore.setGameTitle("+++超级玛丽+++");
		GameCore.setGameSize(800, 480);// 窗口大小控制
		GameCore.loadBgView("t01b1a2a2945c2ee923.jpg");// 加载马里奥的背景图片
		GameCore.playSound("群星 - FC《超级玛丽》地上关BGM.mp3", true);

		

		//超级玛丽 文字的控制
		int MarioNum = 0;
		GameCore.createText(MarioNum, "超级玛丽");
		GameCore.setTextColor(MarioNum, Color.pink);
		GameCore.setTextFontSize(MarioNum, 50);
		GameCore.setTextPosition(MarioNum, 200, 50);
		
		//1-单人游戏 的文字控制
		int singlegame=1;
		GameCore.createText(singlegame, "1-单人游戏");
		GameCore.setTextColor(singlegame, Color.pink);
		GameCore.setTextFontSize(singlegame, 30);
		GameCore.setTextPosition(singlegame, 200, 150);
		
		//2-双人游戏 的文字控制
		int doublegame=2;
		GameCore.createText(doublegame, "2-双人游戏");
		GameCore.setTextColor(doublegame, Color.pink);
		GameCore.setTextFontSize(doublegame, 30);
		GameCore.setTextPosition(doublegame, 200, 200);
		
		//3-游戏演示 的文字控制
		int domegame=3;
		GameCore.createText(domegame, "3-游戏演示");
		GameCore.setTextColor(domegame, Color.pink);
		GameCore.setTextFontSize(domegame, 30);
		GameCore.setTextPosition(domegame, 200, 250);
		
//马里奥在屏幕移动	
		//创建马里奥精灵
		int marioNum=2;
		int marioY=350;
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpriteFlipX(marioNum, true);
		GameCore.setSpritePosition(marioNum, 10, marioY);
		//播放马里奥精灵
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		
		//循环控制动作的位置 使其产生动画效果
		for(int marioX=10;marioX<=1000;marioX+=7)
		{
			GameCore.setSpritePosition(marioNum, marioX, marioY);
			GameCore.pause(200);
		}
		
		GameCore.pause(30000000);
	}

	

}
