package com.sundy.www.gamecore;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.KeyEvent;

import com.rupeng.game.GameCore;

public class Frame
{
	/**
	 * 实现精灵的自动移动到px py处
	 * 
	 * @param mario
	 *            需要移动的精灵
	 * @param px
	 *            x处
	 * @param py
	 *            y处
	 */
	public void autoMove(Sprite mario, int px, int py)
	{

		while (true)
		{
			// 当前精灵大于目标的px，则向左移动
			if (GameCore.getSpriteX(mario.getNum()) > px)
			{
				mario.moveLeft();
			}
			// 当前精灵小于目标的px，则向右移动
			else if (GameCore.getSpriteX(mario.getNum()) < px)
			{
				mario.moveRight();
			} else
			{
				break;
			}

		}

		while (true)
		{
			// 当前精灵大于目标的py，则向上移动
			if (GameCore.getSpriteY(mario.getNum()) > py)
			{
				mario.moveUp();
			}
			// 当前精灵小于目标的py，则向下移动
			else if (GameCore.getSpriteY(mario.getNum()) < py)
			{
				mario.moveDown();
			} else
			{
				break;
			}

		}

	}

	/**
	 * 实现自动移动到金币处
	 * 
	 * @param coinArr
	 */
	public void marioAutoEatCoin(Sprite mario, Sprite coin[])
	{
		int minLenCoinNum = 0;// 距离马里奥距离最小的金币的数组编号
		double minlen = 99999999;

		// 实现寻找最小距离的金币的编号

		for (int i = 0; i < coin.length; i++)
		{

			if (Math.pow(
					Math.pow(
							GameCore.getSpriteX(mario.getNum())
									- GameCore.getSpriteX(coin[i].getNum()), 2)
							+ Math.pow(GameCore.getSpriteY(mario.getNum())
									- GameCore.getSpriteY(coin[i].getNum()), 2),
					0.5) < minlen
					&& coin[i].book == 0)// 同时判断金币是否被吃
			{

				minlen = Math
						.pow(Math.pow(GameCore.getSpriteX(mario.getNum())
								- GameCore.getSpriteX(coin[i].getNum()), 2)
								+ Math.pow(
										GameCore.getSpriteY(mario.getNum())
												- GameCore.getSpriteY(coin[i]
														.getNum()), 2), 0.5);

				minLenCoinNum = coin[i].getNum();
			}

		}
		// System.out.println("我被执行了  minLenCoinNum=" + minLenCoinNum);
		autoMove(mario, GameCore.getSpriteX(minLenCoinNum),
				GameCore.getSpriteY(minLenCoinNum));

	}

	/**
	 * 画出开始界面 实现光标的移动和选项的确定
	 */
	public void gameStartFrame()
	{

		GameCore.setGameTitle("超级玛丽吃金币");// 重置窗口的标题
		GameCore.loadBgView("开始界面背景.jpg");// 加载背景画面
		GameCore.playSound("群星 - FC《超级玛丽》地上关BGM.mp3", true);// 加载背景音乐

		// 超级玛丽 大标题
		Text h1 = new Text("超级玛丽", 380, 50, Color.pink, 50);
		// 小标题们
		Text h2 = new Text("1-开始游戏", 400, 150, Color.pink, 30);
		Text h3 = new Text("2-游戏演示", 400, 200, Color.pink, 30);
		Text h4 = new Text("3-游戏帮助", 400, 250, Color.pink, 30);

		int textNum = h1.getNum();// text的临时变量

		// 无限监听键盘事件
		while (true)
		{
			int kc = GameCore.getPressedKeyCode();

			// 如果是up命令，光标向上
			if (kc == KeyEvent.VK_UP)
			{
				textNum--;

				// textNum防止溢出
				if (textNum < h2.getNum())
				{
					textNum = h4.getNum();
				}

				// 所有文字设置为pink色
				for (int i = h1.getNum(); i <= h4.getNum(); i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			// 如果是down命令，光标向下
			if (kc == KeyEvent.VK_DOWN)
			{
				textNum++;

				// textNum防止溢出
				if (textNum > h4.getNum())
				{
					textNum = h2.getNum();
				}

				// 所有文字设置为pink色
				for (int i = h1.getNum(); i <= h4.getNum(); i++)
				{
					GameCore.setTextColor(i, Color.pink);
				}

				GameCore.setTextColor(textNum, Color.orange);
				GameCore.pause(200);
			}

			// 如果得到1 则 开始游戏
			if (kc == KeyEvent.VK_1)
			{
				// 让开始开始界面消失
				h1.hideText();
				h2.hideText();
				h3.hideText();
				h4.hideText();

				Main.whichFrame = 2;// 告诉主方法画出吃金币的画面
				return;

			}

			// 如果得到2 光标选到2-游戏演示
			if (kc == KeyEvent.VK_2)
			{

				// 让开始开始界面消失
				h1.hideText();
				h2.hideText();
				h3.hideText();
				h4.hideText();
				eatCoinFrame(1);// 调用吃金币界面，同时设定flag=1以此让他自动吃金币
				return;

			}

			// 如果得到3 光标选到3-游戏帮助
			if (kc == KeyEvent.VK_3)
			{
				// 让开始开始界面消失
				h1.hideText();
				h2.hideText();
				h3.hideText();
				h4.hideText();
				
				//GameCore.hideImage(num);
				
				Main.whichFrame=3;// 告诉主方法画出游戏帮助的界面
				return;
			}

			// 如果得到了确认的命令，判断执行谁
			if (kc == KeyEvent.VK_ENTER)
			{
				if (textNum == h2.getNum())// 获得1-开始游戏的指令
				{
					// 让开始开始界面消失
					h1.hideText();
					h2.hideText();
					h3.hideText();
					h4.hideText();

					Main.whichFrame = 2;// 告诉主方法画出吃金币的画面
					return; // 函数结束
				}

			}

		}
	}

	/**
	 * 画出吃金币的界面
	 */
	public void eatCoinFrame(int flag)
	{
		// 加载背景画面
		GameCore.loadBgView("吃金币的背景.jpg");
		// 加载游戏文字
		Text F1_auto = new Text("|F1-自动模式", 2, 10, Color.YELLOW, 20);
		Text F2_return = new Text("|F2_返回", 130, 10, Color.YELLOW, 20);
		Text F3_exit = new Text("|F3_退出游戏|", 218, 10, Color.YELLOW, 20);

		Text tempText = new Text("多按几次就有反应了--!", 360, 10, Color.YELLOW, 20);

		// 加载记分板
		Text text_coin_sum = new Text("X0", 960, 7, Color.green, 20);// 计分器
		int int_coin_sum = 0;// 获得了多少金币
		Sprite tempCoin = new Sprite("coin", 940, 10);
		tempCoin.play("rotate");

		// 加载精灵马里奥
		Sprite mario = new Sprite("mario", 30, 50);
		mario.play("walk");

		// 加载10个金币
		Sprite coin[] = new Sprite[10];// 金币的对象数组
		for (int i = 0; i < 10; i++)
		{
			// 根据窗体大小生成两个随机数
			int px = GameCore.rand(10, GameCore.getGameWidth() - 50);
			int py = GameCore.rand(40, GameCore.getGameHeight() - 100);

			coin[i] = new Sprite("coin", px, py);
			coin[i].play("rotate");
		}

		// 不断监听键盘事件
		int kc;
		int autoFlag = flag;
		while (true)
		{
			kc = GameCore.getPressedKeyCode();
			// 精灵相应做出反应
			if (kc == KeyEvent.VK_LEFT)
			{
				mario.moveLeft();
			}

			else if (kc == KeyEvent.VK_RIGHT)
			{
				mario.moveRight();
			}

			else if (kc == KeyEvent.VK_UP)
			{
				mario.moveUp();
			}

			else if (kc == KeyEvent.VK_DOWN)
			{
				mario.moveDown();
			} else if (kc == KeyEvent.VK_F3)// 正常退出
			{
				System.exit(0);
			} else if (kc == KeyEvent.VK_F1 || autoFlag == 1)// 开启自动吃金币模式
			{
				if (kc == KeyEvent.VK_F3)// 正常退出
				{
					System.exit(0);
				}

				if (kc == KeyEvent.VK_F2)// 让当前所有文字以及精灵消失
				{
					hideEatCoinFrame(coin, mario, tempCoin, F1_auto, F2_return,
							F3_exit, tempText, text_coin_sum);

					Main.whichFrame = 1;// 告诉主函数画出开始画面

					return; // 当前函数结束
				}

				autoFlag = 1;
				marioAutoEatCoin(mario, coin);

			} else if (kc == KeyEvent.VK_F2)// 让当前所有文字以及精灵消失
			{
				// 让当前所有文字以及精灵消失
				hideEatCoinFrame(coin, mario, tempCoin, F1_auto, F2_return,
						F3_exit, tempText, text_coin_sum);

				Main.whichFrame = 1;// 告诉主函数画出开始画面

				return; // 当前函数结束
			}
			// GameCore.pause(1);

			// 循环判断马里奥是否吃到了金币
			for (int i = 0; i < 10; i++)
			{
				if (coin[i].book == 0
						&& Sprite.xiangjiao(coin[i].getNum(), mario.getNum()))
				{
					coin[i].book = 1;// 标记吃过了
					GameCore.hideSprite(coin[i].getNum());// 隐藏精灵

					// 记分板增加
					int_coin_sum++;
					GameCore.setText(text_coin_sum.getNum(), "X" + int_coin_sum);

					// 因为少了个金币，所以加个金币
					// 根据窗体大小生成两个随机数
					int px = GameCore.rand(10, GameCore.getGameWidth() - 50);
					int py = GameCore.rand(40, GameCore.getGameHeight() - 50);

					coin[i] = new Sprite("coin", px, py);
					coin[i].play("rotate");

				}
			}

		}

	}

	/**
	 * 画出游戏帮助界面
	 */
	public void gameHelpFrame()
	{
		//加载文字
		Text F2_return = new Text("|F2_返回", 130, 10, Color.YELLOW, 20);
		Text F3_exit = new Text("|F3_退出游戏|", 218, 10, Color.YELLOW, 20);
        Text tempText=new Text("并不知道该说些什么--，游戏写的挺烂的，只是为了练习下Java--!", 10, 30, Color.white, 30);
        Text tempText2=new Text("                                      By Sundy (*^__^*) ", 10, 200, Color.white, 30);
       
		int kc=0;
		while (true) 
		{
			kc = GameCore.getPressedKeyCode();
			if (kc == KeyEvent.VK_F3)// 正常退出
			{
				System.exit(0);
			} else if (kc == KeyEvent.VK_F2)// 让当前所有文字以及精灵消失
			{
				//让当前文本消失
                GameCore.hideText(F2_return.getNum());
                GameCore.hideText(F3_exit.getNum());
                GameCore.hideText(tempText.getNum());
                GameCore.hideText(tempText2.getNum());
                // 告诉主函数画出开始画面      
				Main.whichFrame = 1;
				// 当前函数结束
				return; 
			}
		}

	}

	/**
	 * 让吃金币界面消失
	 * 
	 * @param coin
	 *            传入金币数组
	 * @param mario
	 *            马里奥编号
	 * @param tempcoin
	 *            临时的小金币
	 * @param t1
	 *            文字编号1
	 * @param t2
	 *            文字编号2
	 * @param t3
	 *            文字编号3
	 * @param t4
	 *            文字编号4
	 * @param coin_sum
	 *            积分器
	 */
	public void hideEatCoinFrame(Sprite coin[], Sprite mario, Sprite tempcoin,
			Text t1, Text t2, Text t3, Text t4, Text coin_sum)
	{
		// 让金币消失
		for (int i = 0; i < 10; i++)
		{
			GameCore.hideSprite(coin[i].getNum());
			coin[i] = null;// 释放金币这个对象
		}

		// 让马里奥消失
		GameCore.hideSprite(mario.getNum());
		mario = null;

		// 让文字消失
		GameCore.hideText(t1.getNum());
		t1 = null;
		GameCore.hideText(t2.getNum());
		t2 = null;
		GameCore.hideText(t3.getNum());
		t3 = null;
		GameCore.hideText(t4.getNum());
		t4 = null;

		// 积分器消失
		GameCore.hideText(coin_sum.getNum());
		coin_sum = null;
		GameCore.hideSprite(tempcoin.getNum());
	}

}
