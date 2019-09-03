package Game.Entities.Static;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.GraphicAttribute;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

    private Handler handler;

    public int xCoord;
    public int yCoord;
    Graphics g;

    
    public Apple(Handler handler,int x, int y){
        this.handler=handler;
        this.xCoord=x; 
        this.yCoord=y; 
        

    }

}
