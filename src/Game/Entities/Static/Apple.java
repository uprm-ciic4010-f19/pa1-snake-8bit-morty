package Game.Entities.Static;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.GraphicAttribute;

import Game.Entities.Dynamic.Player;
import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

    private Handler handler;

    public int xCoord;
    public int yCoord, born, dead;
    public static boolean good;
    public boolean isFresh = true;
    Graphics g;

    
    public Apple(Handler handler,int x, int y){
        this.handler=handler;
        this.xCoord=x; 
        this.yCoord=y; 
        this.born = Player.stepCount;
        this.isFresh = isGood();
        
    }
    public boolean isGood() {
    	if (isFresh) {
    		if (Player.stepCount > (born+600)) {
    			good = false;
    		}
    		else {
    			good = true;
    			
    		}
		}
    	
		return good;
    	
    }

}
