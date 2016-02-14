package com.sundy.www.gamecore;

import com.rupeng.game.*;

public class Sprite
{
	private int spriteNum;// 精灵的编号
	private String spriteName;// 精灵的名字

	/**
	 * 是否被标记了，用于判断金币是否被吃了 一般没别的用处了
	 */
	public int book = 0;

	/**
	 * 构造函数 精灵的名字
	 * @param spriteName
	 *            精灵名字
	 * @param px
	 *            x坐标
	 * @param py
	 *            y坐标
	 */
	public Sprite(String spriteName, int px, int py)
	{
		this.spriteNum = NumerManager.instance.getNum();
		GameCore.createSprite(spriteNum, spriteName);
		GameCore.setSpritePosition(spriteNum, px, py);
		this.spriteName = spriteName;
	}

	/**
	 * 构造函数 位置在默认位置 0，0
	 * 
	 * @param spriteName
	 *            精灵名字
	 */
	public Sprite(String spriteName)
	{
		this.spriteNum = NumerManager.instance.getNum();
		GameCore.createSprite(spriteNum, spriteName);
		GameCore.setSpritePosition(spriteNum, 0, 0);
		this.spriteName = spriteName;
	}

	/**
	 * 得到精灵的编号
	 * 
	 * @return 返回精灵的编号
	 */
	public int getNum()
	{
		return spriteNum;
	}

	/**
	 * 播放精灵
	 * 
	 * @param animateName
	 *            播放什么行为
	 * 
	 * @param repeat
	 *            是否循环
	 * 
	 */
	public void play(String animateName, boolean repeat)
	{
		GameCore.playSpriteAnimate(spriteNum, animateName, repeat);
	}

	/**
	 * 播放精灵
	 * 
	 * @param animateName
	 *            播放什么行为 默认是一直播放
	 * 
	 */
	public void play(String animateName)
	{
		GameCore.playSpriteAnimate(spriteNum, animateName, true);
	}

	/**
	 * 精灵向右移动一个单位
	 */
	public void moveRight()
	{
		// 防止越界
		if (GameCore.getSpriteX(spriteNum) > GameCore.getGameWidth() - 50)
		{
			return;
		}
		GameCore.setSpritePosition(spriteNum,
				GameCore.getSpriteX(spriteNum) + 1,
				GameCore.getSpriteY(spriteNum));
	}

	/**
	 * 精灵向左移动一个单位
	 */
	public void moveLeft()
	{
		// 防止越界
		if (GameCore.getSpriteX(spriteNum) <= 10)
		{
			return;
		}
		GameCore.setSpritePosition(spriteNum,
				GameCore.getSpriteX(spriteNum) - 1,
				GameCore.getSpriteY(spriteNum));
	}

	/**
	 * 精灵向上移动一个单位
	 */
	public void moveUp()
	{
		// 防止越界
		if (GameCore.getSpriteY(spriteNum) < 40)
		{
			return;
		}
		GameCore.setSpritePosition(spriteNum, GameCore.getSpriteX(spriteNum),
				GameCore.getSpriteY(spriteNum) - 1);
	}

	/**
	 * 精灵向下移动一个单位
	 */
	public void moveDown()
	{
		// 防止越界
		if (GameCore.getSpriteY(spriteNum) > GameCore.getGameHeight() )
		{
			return;
		}
			
			GameCore.setSpritePosition(spriteNum,
					GameCore.getSpriteX(spriteNum),
					GameCore.getSpriteY(spriteNum) + 1);
	}

	/**
	 * 实现判断两个精灵是否相交
	 * 
	 * @param sprite1
	 *            精灵1
	 * @param sprite2
	 *            精灵2
	 * @return true相交 false不相交
	 */
	public static boolean xiangjiao(int sprite1, int sprite2)
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

		if (GameCore.getSpriteX(sprite2) + GameCore.getSpriteWidth(sprite2) < GameCore
				.getSpriteX(sprite1))
		{
			return false;
		}

		if (GameCore.getSpriteX(sprite1) + GameCore.getSpriteWidth(sprite1) < GameCore
				.getSpriteX(sprite2))
		{
			return false;
		}

		return true;
	}

}
