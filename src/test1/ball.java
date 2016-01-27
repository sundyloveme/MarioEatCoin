package test1;

import java.awt.Color;

import com.rupeng.game.GameCore;

public class ball implements Runnable
{

	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		int ball = 0;
		GameCore.createSprite(ball, "ball1");
		GameCore.playSpriteAnimate(ball, "rotate", true);
		GameCore.setSpritePosition(ball, 100, 0);

		int singlegame = 1;// 其实是画条横线 没改变量名
		GameCore.createText(singlegame, "_______________");
		GameCore.setTextColor(singlegame, Color.pink);
		GameCore.setTextFontSize(singlegame, 30);
		GameCore.setTextPosition(singlegame, 100, 300);

		double y = 0, t = 1, v = 0;

		for (;;)
		{
			v=v+0.5*9.8*t*t;
			y=y+v*t;
			if(y>=300){
				v*=-1;
			}
			
					
			GameCore.setSpritePosition(ball, 100, (int) y);
			GameCore.pause(150);

		}

		
	}

	public static void main(String[] args)
	{
		GameCore.start(new ball());
		// TODO 自动生成的方法存根

	}

}
