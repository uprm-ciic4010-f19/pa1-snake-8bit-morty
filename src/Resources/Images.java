package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Images {


    public static BufferedImage[] butstart;
    public static BufferedImage title;
    public static BufferedImage Pause;
    public static BufferedImage[] altHard;
    public static BufferedImage[] altTitle;
	public static BufferedImage[] altEasy;
    public static BufferedImage gOver;
    public static BufferedImage[] Resume;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] Options;
	public static BufferedImage[] menu;
	public static BufferedImage[] restart;

    public static ImageIcon icon;

    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[2];
        menu = new BufferedImage[2];
        restart = new BufferedImage[2];
        altEasy = new BufferedImage[2];
        altHard = new BufferedImage[2];

        try {
//        	ADDED IMGES 
        	title = ImageIO.read(getClass().getResourceAsStream("/Sheets/Main.png"));
        	altEasy[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Easy.png"));
        	altEasy[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Easy-1.png"));
        	altHard[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Hard.png"));
        	altHard[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Hard-1.png"));
        	menu[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Menu.png"));
        	menu[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Menu-1.png"));
        	Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
        	Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume-1.png"));
        	Options[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options.png"));
        	Options[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options-1.png"));
        	restart[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/restart.png"));
        	restart[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/restart-1.png"));
        	
//        	STOCK IMAGES
        	
            Pause = ImageIO.read(getClass().getResourceAsStream("/Buttons/Pause.png"));
            gOver = ImageIO.read(getClass().getResourceAsStream("/Sheets/gover.jpg")); 

            BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
            BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
           
            butstart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormBut.png"));//normbut
            butstart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverBut.png"));//hoverbut
            butstart[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ClickedBut.png"));//clickbut

            icon =  new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/icon.png")));


        }catch (IOException e) {
        e.printStackTrace();
    }


    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
