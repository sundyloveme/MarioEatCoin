//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................    
//=========================================
//引用了如鹏的游戏引擎 测试引擎的一些简单方法
//实现了加载图片和加载音乐
//注意图片音乐等资源存在的位置在包中
//2015年12月27日14:16:50
//=========================================
package test1;

import java.security.PrivateKey;

import com.rupeng.game.*;

public class Main implements Runnable
{
	public static void main(String[] args)
	{
		// // TODO 自动生成的方法存根
		// System.out.println("lee");

		GameCore.start(new Main());
	}

	public void run()
	{
		int mp3_time = 20000;//切歌时间
		GameCore.setGameTitle("++++++每隔" + mp3_time / 1000 + "秒切歌++++++");

		while (true)
		{

			GameCore.loadBgView("1259648166_UUXX3h.jpg");
			GameCore.playSound("T-ara - SEXY LOVE.mp3", true);
			GameCore.pause(mp3_time);
			GameCore.closeSound("T-ara - SEXY LOVE.mp3");

			GameCore.loadBgView("19_140722151348_3.jpg");
			GameCore.playSound("T-ara - 넘버나인 (No.9).mp3", true);
			GameCore.pause(mp3_time);
			GameCore.closeSound("T-ara - 넘버나인 (No.9).mp3");

			GameCore.loadBgView("eb1312250030.jpg");
			GameCore.playSound("T-ara - 완전 미쳤네 (Korean Ver.).mp3", true);
			GameCore.pause(mp3_time);
			GameCore.closeSound("T-ara - 완전 미쳤네 (Korean Ver.).mp3");
		}
//		String s2=GameCore.input("", "第二个数字");
//		String s1=GameCore.input("", "第一个数字");
//		GameCore.alert("之和为"+(Integer.parseInt(s1)+Integer.parseInt(s2)));
				
	}

}
