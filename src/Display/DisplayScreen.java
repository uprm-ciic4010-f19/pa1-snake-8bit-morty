package Display;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Created by AlexVR on 7/1/2018.
 */

public class DisplayScreen {

    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width, height;
   

    public DisplayScreen(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height; 


        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.black);

        try {
            frame.setIconImage(ImageIO.read(new File("res/Sheets/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        
        canvas.setBackground(rgbCol());


     

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }
    
    private static Color rgbCol() {
   	 Color[] bgColors = new Color[11];
   	    Random r = new Random();
//   	    PURPLE BACKGROUND COLORS
   	   Color col = new Color(164, 116, 188);
   	      bgColors[0] = new Color(216,191,216);
   	      bgColors[1] = new Color(221,160,221);
   	      bgColors[2] = new Color(238,130,238);
   	      bgColors[3] = new Color(218,112,214);
   	      bgColors[4] = new Color(255,0,255);
   	      bgColors[5] = new Color(186,85,211);
   	      bgColors[6] = new Color(147,112,219);
   	      bgColors[7] = new Color(138,43,226);
   	      bgColors[8] = new Color(148,0,211);
   	      bgColors[9] = new Color(153,50,204);
   	      bgColors[10] = new Color(139,0,139);
   	      int value = (int) (10 * Math.random());
   	      
   	      Color bgCol = bgColors[value];
   	return bgCol;
   }
    public JFrame getFrame(){
        return frame;
    }
   

}
