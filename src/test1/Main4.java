package test1;//2016年1月16日16:37:51

import java.awt.Dimension;

import com.rupeng.game.GameCore;

public class Main4 implements Runnable
{

	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		int ball = 0;
		int x = 100, y = 0;// 初始坐标
		int vx = 2, vy = 1;// 横向速度 纵向速度
		int t = 3; // 时间
		Dimension gamesize=GameCore.getGameSize();//得到窗体大小
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, x, y);
		//
		while (true)
		{
			x += vx * t;
			y += vy * t;
			GameCore.setSpritePosition(ball, x, y);
			GameCore.pause(10);

			if (x >= gamesize.width-20 || x <= 0)
			{
				vx *= -1;
			}
			if (y >= gamesize.height-40 || y <= 0)
			{
				vy *= -1;
			}
		}

	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		GameCore.start(new Main4());

	}

}
