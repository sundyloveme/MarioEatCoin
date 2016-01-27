package test1;

import com.rupeng.game.GameCore;

public class LianLianKan implements Runnable
{
	public int[][] map =
	// 建立练练看基本地图
	{
	{ 0, 0, 0, 0, 0, 0 },// 0
			{ 0, 0, 0, 0, 0, 0 },// 1
			{ 0, 0, 0, 0, 0, 0 },// 2
			{ 0, 0, 0, 0, 0, 0 },// 3
			{ 0, 0, 0, 0, 0, 0 },// 4
			{ 0, 0, 0, 0, 0, 0 },// 5
	};

	int imgNum = 2;

	@Override
	public void run()
	{
		GameCore.setGameSize(480, 500);
		
		// 遍历map
		for (int i = 0; i < 6; i++)
		{
			int tempInt[] = map[i];

			for (int j = 0; j < tempInt.length; j++)
			{

				if (tempInt[j] == 0)
				{
					//mousePressed();
					//MouseActionlistener
					GameCore.createImage(imgNum, "蛋蛋.jpg");
					GameCore.setImagePosition(imgNum, j*80, i*80);
					imgNum++;
				} else if (tempInt[j] == 1)
				{

				} else if (tempInt[j] == 2)
				{

				} else if (tempInt[j] == 3)
				{

				} else if (tempInt[j] == 4)
				{

				} else if (tempInt[j] == 5)
				{

				}

			}
			// System.out.println();
		}
		
		while(true){
			
		}
		
	}

	public static void main(String[] args)
	{

		GameCore.start(new LianLianKan());

	}

}
