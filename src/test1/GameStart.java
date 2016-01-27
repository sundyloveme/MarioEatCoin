package test1;

import java.awt.Color;

import com.rupeng.game.GameCore;
//定义超级玛丽开始界面这个类
//封装了很多常用的方法

public class GameStart
{

	// 文字的编号
	int MarioNum = 0;
	int gameStart = 1;// 1-开始游戏
	int gameDome = 2;// 2-游戏演示
	int gameHelp = 3;// 3-帮助

	public void drawGame()
	{

		// 开始界面 文字的显示
		// GameCore.setGameTitle("+++超级玛丽+++");
		// GameCore.setGameSize(800, 480);// 窗口大小控制
		GameCore.loadBgView("开始界面背景.jpg");// 加载马里奥的背景图片
		// GameCore.playSound("群星 - FC《超级玛丽》地上关BGM.mp3", true);

		// 超级玛丽 文字的控制

		GameCore.createText(MarioNum, "超级玛丽");
		GameCore.setTextColor(MarioNum, Color.pink);
		GameCore.setTextFontSize(MarioNum, 50);
		GameCore.setTextPosition(MarioNum, 380, 50);

		// 1-开始游戏 的文字控制

		GameCore.createText(gameStart, "1-开始游戏");
		GameCore.setTextColor(gameStart, Color.pink);
		GameCore.setTextFontSize(gameStart, 30);
		GameCore.setTextPosition(gameStart, 400, 150);

		// 2-游戏演示 的文字控制

		GameCore.createText(gameDome, "2-游戏演示");
		GameCore.setTextColor(gameDome, Color.pink);
		GameCore.setTextFontSize(gameDome, 30);
		GameCore.setTextPosition(gameDome, 400, 200);

		// 3-帮助的文字控制

		GameCore.createText(gameHelp, "3-游戏帮助");
		GameCore.setTextColor(gameHelp, Color.pink);
		GameCore.setTextFontSize(gameHelp, 30);
		GameCore.setTextPosition(gameHelp, 400, 250);

		GameCore.pause(900);

	}

	// 隐藏文字
	public void hidelText()
	{

		GameCore.setText(MarioNum, "");
		GameCore.setText(gameStart, "");
		GameCore.setText(gameDome, "");
		GameCore.setText(gameHelp, "");

	}

}
