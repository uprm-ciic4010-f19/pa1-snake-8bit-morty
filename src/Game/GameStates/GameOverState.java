package Game.GameStates;

import Main.Handler; 
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

import Game.Entities.Dynamic.Player;


public class GameOverState extends State {

	private int count = 0;
	private UIManager uiManager;

	public GameOverState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUimanager(uiManager);

		
		  uiManager.addObjects(new UIImageButton(56, (350+(64+16))+(64+16), 128, 64, Images.menu, () -> {
	            handler.getMouseManager().setUimanager(null);
	            State.setState(handler.getGame().menuState);
	        }));
		  
		  uiManager.addObjects(new UIImageButton(56, (400+(64+16))+(64+16), 128, 64, Images.restart, () -> {
	            handler.getMouseManager().setUimanager(null);
	            handler.getGame().reStart();
	            Player.trackscore = 0;
	            State.setState(handler.getGame().gameState);
	        }));

	}

	@Override
	public void tick() {
		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Images.gOver,0,0,handler.getWidth(),handler.getHeight(),null);
        uiManager.Render(g);

        Player.paintComponent(g, 300, 64);
	}

}
