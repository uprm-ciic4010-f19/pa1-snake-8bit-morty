package Game.Entities.Static;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.GraphicAttribute;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import Game.Entities.Dynamic.Player;
import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

	private Handler handler;

	public int xCoord;
	public int yCoord, born;

	public static int dead;
	public static boolean good;

	public Apple(Handler handler, int x, int y) {
		good = true;
		this.handler = handler;
		this.xCoord = x;
		this.yCoord = y;
		this.born = Player.stepCount;
//	        STEP TIMER
		Apple.dead = born + 60; // TIME IN THE FUTURE FOR APPLE TO ROT
	}

	public static boolean isGood() {
		if (Player.stepCount > dead) {
			good = false;
		} else {
			good = true;
		}
		if (Player.stepCount % 60 == 0) {
			System.out.println("Apple is " + good + " >> " + Player.stepCount);
		}
		return good;
	}

}
