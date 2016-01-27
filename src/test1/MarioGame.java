package test1;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;
/**
 * 这是一个方法
 * @author Administrator
 *
 */
public class MarioGame implements Runnable
{
	// 马里奥精灵的编号
	int marioNum = 0;
	int coinSum = 10;// 生成金币的数量
	int flag = 1;// 是否切换到自动吃金币模式

	Mario mario = new Mario(marioNum);// 新建马里奥这个类
	GameStart gamestrat = new GameStart();// 新建游戏开始界面的类

	// 实现判断两个精灵是否相交
	// true相交 false不相交
	//使用了矩形法判断
	/**
	 * 实现判断两个精灵是否相交
	 * @param sprite1 精灵1
	 * @param sprite2 精灵2
	 * @return true相交 false不相交
	 */
	public boolean xiangjiao(int sprite1, int sprite2)
	{
		if (GameCore.getSpriteY(sprite1) + GameCore.getSpriteHeight(sprite1) < GameCore
				.getSpriteY(sprite2))
		{
			return false;
		}

		if (GameCore.getSpriteY(sprite2) + GameCore.getSpriteHeight(sprite2) < GameCore
				.getSpriteY(sprite1))
		{
			return false;
		}

		
		if(GameCore.getSpriteX(sprite2) + GameCore.getSpriteWidth(sprite2) < GameCore
				.getSpriteX(sprite1))	
		{
			return false;
		}
		
		if(GameCore.getSpriteX(sprite1) + GameCore.getSpriteWidth(sprite1) < GameCore
				.getSpriteX(sprite2))	
		{
			return false;
		}
		
		
		return true;
	}

	// 实现马里奥自动走到px，py处
	public void autoMove(int px, int py)
	{

		while (true)
		{

			if (GameCore.getSpriteX(marioNum) > px)
			{
				mario.marioMove(KeyEvent.VK_LEFT);
			}

			else if (GameCore.getSpriteX(marioNum) < px)
			{
				mario.marioMove(KeyEvent.VK_RIGHT);
			} else
			{
				break;
			}

		}

		while (true)
		{

			if (GameCore.getSpriteY(marioNum) > py)
			{
				mario.marioMove(KeyEvent.VK_UP);
			}

			else if (GameCore.getSpriteY(marioNum) < py)
			{
				mario.marioMove(KeyEvent.VK_DOWN);
			} else
			{
				break;
			}

		}

	}

	// 实现马里奥自动吃金币
	// 传入金币数组
	public void marioAutoEatCoin(int[] coinArr)
	{
		int minLenCoinNum = 0;// 距离马里奥距离最小的金币的编号
		double minlen = 99999999;
		// int[] coinArr = new int[coinSum];// 金币是否被吃的数组

		// 实现寻找最小距离的金币的编号
		// 我知道金币的编号从20开始的
		for (int i = 20; (i <= coinSum + 20 - 1); i++)
		{

			if (Math.pow(
					Math.pow(
							GameCore.getSpriteX(marioNum)
									- GameCore.getSpriteX(i), 2)
							+ Math.pow(
									GameCore.getSpriteY(marioNum)
											- GameCore.getSpriteY(i), 2), 0.5) < minlen
					&& coinArr[i - 20] == 0)// 同时判断金币是否被吃
			{

				minlen = Math.pow(
						Math.pow(
								GameCore.getSpriteX(marioNum)
										- GameCore.getSpriteX(i), 2)
								+ Math.pow(GameCore.getSpriteY(marioNum)
										- GameCore.getSpriteY(i), 2), 0.5);

				minLenCoinNum = i;
			}
			// System.out.println("我被执行了  minLenCoinNum=" + minLenCoinNum);
		}

		autoMove(GameCore.getSpriteX(minLenCoinNum),
				GameCore.getSpriteY(minLenCoinNum));

	}

	// 1-开始游戏
	public void marioChiJinBi()
	{

		int textNum = 11;// 文字编号
		int getCoinSum = 0;// 获得金币的数量
		String strGetCoin = " X0";

		int[] coinArr = new int[coinSum];

		// 生成“F1自动模式”文字
		GameCore.createText(textNum - 1, "F1自动模式");
		GameCore.setTextColor(textNum - 1, Color.WHITE);
		GameCore.setTextFontSize(textNum - 1, 19);
		GameCore.setTextPosition(textNum - 1, 10, 5);

		// 生成获得金币数量的文字
		GameCore.createSprite(7, "coin_Big");
		GameCore.setSpritePosition(7, 910, 0);
		GameCore.playSpriteAnimate(7, "rotate", true);

		GameCore.createText(textNum, strGetCoin);
		GameCore.setTextPosition(textNum, 920, 0);
		GameCore.setTextColor(textNum, Color.WHITE);

		// 生成金币 编号从20开始
		for (int i = 20; i <= coinSum + 20 - 1; i++)
		{
			GameCore.createSprite(i, "coin");
			GameCore.setSpritePosition(i, GameCore.rand(10, 900),
					GameCore.rand(10, 500));
			GameCore.playSpriteAnimate(i, "rotate", true);
		}

		// 开始循环监听键盘事件并控制马里奥的位置
		while (true)
		{
			int kc = GameCore.getPressedKeyCode();

			if (kc == KeyEvent.VK_F1)
			{

				flag = 0;

			}

			if (flag == 1)// 手动模式
			{
				mario.marioMove(kc);// 传入移动指令

			} else if (flag == 0)// 自动模式
			{
				marioAutoEatCoin(coinArr);
			}

			//

			// 判断吃了那些金币
			for (int i = 20; i <= coinSum + 20 - 1; i++)
			{
				// 点到点距离公式&金币是否被吃了
//				if (Math.pow(
//						Math.pow(
//								GameCore.getSpriteX(marioNum)
//										- GameCore.getSpriteX(i), 2)
//								+ Math.pow(GameCore.getSpriteY(marioNum)
//										- GameCore.getSpriteY(i), 2), 0.5) <= 30
//						&& coinArr[i - 20] == 0)
				if(xiangjiao(marioNum, i)&&coinArr[i - 20] == 0)//判断是否相交
				{
					coinArr[i - 20] = 1;
					GameCore.hideSprite(i);
					getCoinSum++;
					strGetCoin = " X" + getCoinSum;
					GameCore.setText(textNum, strGetCoin);
				
				}

			}

			// GameCore.pause(1);

		}
	}

	@Override
	public void run()
	{
		GameCore.setGameTitle("不知道叫什么好，就叫吃屎好了");// 标题设置

		mario.playMarioSound();// 播放马里奥背景音乐
		gamestrat.drawGame();// 画出界面

		// 开始界面的操控
		int textNum = 0;
		while (true)
		{
			int kc = GameCore.getPressedKeyCode();

			if (kc == KeyEvent.VK_UP)
			{
				textNum--;

				// textNum防止溢出
				if (textNum <= 0)
				{
					textNum = 3;
				}

				// 所有文字设置为pink色
				for (int i = 1; i <= 3; i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			if (kc == KeyEvent.VK_DOWN)
			{
				textNum++;

				// textNum防止溢出
				if (textNum > 3)
				{
					textNum = 1;
				}

				// 所有文字设置为pink色
				for (int i = 1; i <= 3; i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			if (kc == KeyEvent.VK_ENTER)
			{
				if (textNum == 1)// 获得1-开始游戏的指令
				{
					gamestrat.hidelText();// 隐藏文字
					GameCore.loadBgView("吃金币的背景.jpg");// 背景图片
					mario.drawMarioWalk(300, 400);// 画出马里奥
					marioChiJinBi();// 执行开始游戏

				}

			}

		}

	}

	public static void main(String[] args)
	{
		GameCore.start(new MarioGame());

	}

}
