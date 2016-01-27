package test1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;
import java.util.Random;

import com.rupeng.game.GameCore;
//2016年1月17日16:54:19
//马里奥吃金币的实现

public class ChiJinBi implements Runnable
{

	@Override
	public void run()
	{
		Random rand1 = new Random();// 种子
		String coinsum = "0 x";
		int kc;// 键盘的值
		int marioNum = 0;
		int coinNum = 1;
		int textNum = 3;
		int dx = 5, dy = 5;// x，y的增量
		Point marioPos = new Point();
		marioPos.x = 200;
		marioPos.y = 200;// 超级玛丽的坐标
		Dimension gamesize = GameCore.getGameSize();

		// 随机生成金币5个
		int coinN = 20;// 控制金币的数量
		for (int i = 4; i <= coinN + 4 - 1; i++)// i作为编号不能与上面重复,所以从4→8
		{

			GameCore.createSprite(i, "coin");
			GameCore.setSpritePosition(i,
					Math.abs(rand1.nextInt() % gamesize.width - 90),
					Math.abs(rand1.nextInt() % gamesize.height - 100));
			GameCore.playSpriteAnimate(i, "rotate", true);
		}

		// 设置标题
		GameCore.setGameTitle("===++++===");

		// 设置文字，获得金币的数量
		GameCore.createText(textNum, coinsum);
		GameCore.setTextColor(textNum, Color.yellow);
		GameCore.setTextFontSize(textNum, 25);
		GameCore.setTextPosition(textNum, gamesize.width - 70, 0);

		// 载入金币
		GameCore.createSprite(coinNum, "coin");
		GameCore.setSpritePosition(coinNum, gamesize.width - 20, 10);
		GameCore.playSpriteAnimate(coinNum, "rotate", true);

		// 载入马里奥
		GameCore.createSprite(marioNum, "mario");
		GameCore.setSpritePosition(marioNum, marioPos.x, marioPos.y);
		// 播放马里奥
		GameCore.playSpriteAnimate(marioNum, "walk", true);
		// 载入背景图片，草地
		GameCore.loadBgView("CaoDi.jpg");

		// 背景音效
		GameCore.playSound("群星 - FC《超级玛丽》地上关BGM.mp3", true);

		int csum = 0;//得到的金币数量
		int[] coinBook = new int[coinN];//金币标记数组
		while (true)
		{
			kc = GameCore.getPressedKeyCode();// 获取键盘事件
			if (kc == 'a' || kc == 'A')// ←
			{
				if (marioPos.x >= 10)
				{
					GameCore.setSpriteFlipX(marioNum, false);
					dx = -5;
					dy = 0;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}
			}

			else if (kc == 'd' || kc == 'D')// →
			{
				if (marioPos.x <= gamesize.width - 50)
				{

					GameCore.setSpriteFlipX(marioNum, true);
					dx = 5;
					dy = 0;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}
			}

			else if (kc == 's' || kc == 'S')// ↓
			{
				if (marioPos.y <= gamesize.height - 90)
				{
					dx = 0;
					dy = 5;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}
			}

			else if (kc == 'w' || kc == 'W')// ↑
			{
				if (marioPos.y >= 10)
				{
					dx = 0;
					dy = -5;
					GameCore.setSpritePosition(marioNum, marioPos.x += dx,
							marioPos.y += dy);
				}

			}

			// 判断是否吃到金币了
			for (int i = 4; i <= coinN + 4 - 1; i++)// i作为编号不能与上面重复,所以从4→8
			{

				Point coinPos = GameCore.getSpritePosition(i); 
				// 两点间距离公式&&此金币没有吃过
				if (Math.pow(
						Math.pow(marioPos.x - coinPos.x, 2)
								+ Math.pow(marioPos.y - coinPos.y, 2), 0.5) <= 50
						&& coinBook[i - 4] == 0)
				{
					coinBook[i - 4] = 1;// 标记下金币吃过了
					csum++;// 得到的金币++
					GameCore.hideSprite(i);
					coinsum = csum + " " + "x";

					GameCore.setText(textNum, coinsum);
				}
			}

			GameCore.pause(10);
		}
	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根

		GameCore.start(new ChiJinBi());
	}

}
