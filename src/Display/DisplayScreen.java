package Display;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

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
        
//        Back grouncd col
//        Color col = new Color(148,108,212);
      Color col = new Color(164, 116, 188);

        canvas.setBackground(col);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
    public void update(Graphics g) {
    	int r =  1 + (int)(Math.random() * 1000), gg =  1 + (int)(Math.random() * 1000), b =  1 + (int)(Math.random() * 1000);
//    	Color purplCol = new Color(r,g,b)
//    	GENERATE RANDOM BACKGROUND COLOR
    	}

}
