package test1;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import com.rupeng.game.GameCore;

//定义超级玛丽这个类
//封装了很多常用的方法
public class Mario
{

	private int marioNum;//马里奥精灵编号

	
	//播放马里奥背景音乐
	public void playMarioSound()
	{
		//GameCore.p
		GameCore.playSound("群星 - FC《超级玛丽》地上关BGM.mp3", true);
	}
	
	// 构造函数，传入马里奥的编号
	public Mario(int marioNum)
	{
		// TODO 自动生成的构造函数存根
		this.marioNum = marioNum;
	}

	// 画出一个走路的马里奥精灵在px，py处，mario.walk
	// 传入精灵编号，x坐标，y坐标
	public void drawMarioWalk(int px, int py)
	{
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, px, py);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
	}

	// 画出一个走路的马里奥精灵，mario.walk
	// 传入精灵编号 缺省坐标，默认100，100
	public void drawMarioWalk()
	{
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, 100, 100);
		GameCore.playSpriteAnimate(marioNum, "walk", true);
	}

	// 实现马里奥的移动
	// 传入精灵，键盘事件
	public void marioMove(int kc)
	{
		if (kc == KeyEvent.VK_LEFT || kc == KeyEvent.VK_A)
		{
			moveLeft();
		}

		else if (kc == KeyEvent.VK_RIGHT || kc == KeyEvent.VK_D)
		{
			moveRight();
		}

		else if (kc == KeyEvent.VK_UP || kc == KeyEvent.VK_W)
		{
			moveUp();
		}

		else if (kc == KeyEvent.VK_DOWN || kc == KeyEvent.VK_S)
		{
			moveDown();
		}
	}

	// 实现精灵向右走动一个像素
	public void moveRight()
	{

		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.x >= GameCore.getGameWidth() - 50)// 防止越界
		{
			return;
		}
		GameCore.setSpriteFlipX(marioNum, true);
		GameCore.setSpritePosition(marioNum, marioPoint.x + 1, marioPoint.y);
		return;
	}

	// 实现精灵向左走动一个像素
	public void moveLeft()
	{
		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.x <= 10)// 防止越界
		{
			return;
		}
		GameCore.setSpriteFlipX(marioNum, false);
		GameCore.setSpritePosition(marioNum, marioPoint.x - 1, marioPoint.y);
		return;
	}

	// 实现精灵向上走动一个像素
	public void moveUp()
	{
		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.y <= 10)// 防止越界
		{
			return;
		}
		GameCore.setSpritePosition(marioNum, marioPoint.x, marioPoint.y - 1);
		return;
	}

	// 实现精灵向下走动一个像素
	public void moveDown()
	{
		Point marioPoint = GameCore.getSpritePosition(marioNum);
		if (marioPoint.y >= GameCore.getGameHeight() - 80)// 防止越界
		{
			return;
		}
		GameCore.setSpritePosition(marioNum, marioPoint.x, marioPoint.y + 1);
		return;
	}

}
