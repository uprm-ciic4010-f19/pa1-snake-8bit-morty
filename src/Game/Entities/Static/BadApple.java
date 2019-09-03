package Game.Entities.Static;

import java.awt.Color;
import java.awt.Graphics;

import Main.Handler;
import javafx.scene.layout.Background;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class BadApple {

	private Handler handler;

	public int xCoord;
	public int yCoord;
	private int appleSize;

	public BadApple(Handler handler,int x, int y){
        this.handler=handler;
        this.xCoord=x; 
        this.yCoord=y;  
        
        
    }

}
