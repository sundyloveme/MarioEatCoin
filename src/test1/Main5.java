package test1;

import com.rupeng.game.GameCore;

public class Main5 implements Runnable
{

	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		int textnum = 0;
		int h, m, s;
		GameCore.createText(textnum, "****");
		GameCore.setTextPosition(textnum, 50, 30);

		for (h = 0; h <= 59; h++)
		{
			for (m = 0; m <= 59; m++)
			{
				for (s = 0; s <= 59; s++)
				{
					String st=h+":"+m+":"+s;
					GameCore.setText(textnum, st);

					GameCore.pause(200);
				}
			}
		}
		

	}

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根

		GameCore.start(new Main5());
	}

}
