package Main;

import Game.Entities.Dynamic.Player;
import Game.Entities.Static.Apple;
import Input.KeyManager;
import Input.MouseManager;
import Worlds.WorldBase;


/**
 * Created by AlexVR on 7/1/2018.
 * Made by the people, for the people...
 */

public class Handler {

    private GameSetUp game;
    private WorldBase world;
    private Apple apple;

    public Handler(GameSetUp game){
        this.game = game;
    }
 

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    	
    
    public void setGame(GameSetUp game) {
        this.game = game;
    }
    public GameSetUp getGame() {
        return game;
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public WorldBase getWorld() {
        return world;
    }

    
    public Player getPlayer() {
    	return getPlayer();
    }
    public void setWorld(WorldBase world) {
        this.world = world;
    }
	public Apple getApple(Apple a) {
		return a;
	}



}
