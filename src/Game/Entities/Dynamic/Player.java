package Game.Entities.Dynamic;

import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import Game.Entities.Static.Apple;
import Game.GameStates.State;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Player {
	public int lenght;
	public boolean justAte;
	private Handler handler;
	public int xCoord;
	public int yCoord;
	public double score;
	public static double trackscore = 0;////
	public static int stepCount = 0;
//	snake color
	Color playerCol = new Color(133, 209, 95);
//	apple colors
	Color badCol = new Color(139, 69, 19);

	public int moveCounter, speed;

	public String direction;// is your first name one?

	public Player(Handler handler) {
		this.handler = handler;
		xCoord = 0;
		yCoord = 0;
		moveCounter = 0;
		direction = "Right";
		justAte = false;
		lenght = 1;
		score = 0;
		stepCount = 0;

	}

	public void tick() {
		moveCounter++;
//        	MOOVE
//		stepCount++;
		if (moveCounter > speed) {
			moveCounter = 0;
			checkCollisionAndMove();
			stepCount++;

		}

		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)
				|| handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)) {

			if (!(direction == "Down")) {
				direction = "Up";
			}

		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)
				|| handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)) {
			if (!(direction == "Up")) {
				direction = "Down";
			}
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)
				|| handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)) {

			if (!(direction == "Right")) {
				direction = "Left";
			}
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)
				|| handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)) {

			if (!(direction == "Left")) {
				direction = "Right";
			}
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)) {

			handler.getWorld().body.addFirst(new Tail(xCoord, yCoord, handler));
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_PLUS)
				|| handler.getKeyManager().keyJustPressed(KeyEvent.VK_EQUALS)) {

			speed--;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_MINUS)) {
			speed++;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_H)) {
			speed = 10;
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {

			State.setState(handler.getGame().pauseState);

		}

	}

	public void checkCollisionAndMove() {
		handler.getWorld().playerLocation[xCoord][yCoord] = false;

		int x = xCoord;
		int y = yCoord;

		switch (direction) {

		case "Left":

			if (xCoord == 0) {
//				kill();

				xCoord = handler.getWorld().GridWidthHeightPixelCount - 1;
			} else {
				xCoord--;
			}
			break;
		case "Right":

			if (xCoord == handler.getWorld().GridWidthHeightPixelCount - 1) {
				xCoord = 0;
//				kill();
			} else {
				xCoord++;
			}
			break;
		case "Up":

			if (yCoord == 0) {
				yCoord = handler.getWorld().GridWidthHeightPixelCount - 1;
			} else {
				yCoord--;
			}
			break;
		case "Down":

			if (yCoord == handler.getWorld().GridWidthHeightPixelCount - 1) {
				yCoord = 0;
//				kill();
			} else {
				yCoord++;
			}
			break;

		}
		if (!handler.getWorld().body.isEmpty()) {
			if (handler.getWorld().playerLocation[xCoord][yCoord]) {
				kill();
			}
		}
		handler.getWorld().playerLocation[xCoord][yCoord] = true;

		if (handler.getWorld().appleLocation[xCoord][yCoord]) {
			Eat();
			speed -= 8;
			System.out.println(handler.getWorld().body.size());
			if (Apple.isGood()) {
				score += Math.sqrt(2 * score + 1);/////

			}
			if (!Apple.isGood()) {
				if (!handler.getWorld().body.isEmpty()) {
					if (handler.getWorld().body.size() > 1) {
						score -= Math.sqrt(2 * score + 1);/////
						handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body
								.getLast().y] = false;
						handler.getWorld().body.removeLast();
						handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body
								.getLast().y] = false;
						handler.getWorld().body.removeLast();
					} else {
						kill();
					}
				} else {
					kill();
				}
				tick();
			}
			trackscore = score;
			System.out.println(score);
		}

		if (!handler.getWorld().body.isEmpty()) {
			handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body
					.getLast().y] = false;
			handler.getWorld().body.removeLast();
			handler.getWorld().body.addFirst(new Tail(x, y, handler));

		}

	}
	

	public void render(Graphics g, Boolean[][] playeLocation) {
		
		
		for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
			for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {

				if (playeLocation[i][j] || handler.getWorld().appleLocation[i][j]) {
					g.setColor(playerCol);
					g.fillRect((i * handler.getWorld().GridPixelsize), (j * handler.getWorld().GridPixelsize),
							handler.getWorld().GridPixelsize, handler.getWorld().GridPixelsize);

				}
				if (handler.getWorld().appleLocation[i][j]) {
					if (Apple.isGood()) {
						g.setColor(Color.RED);
//						GOOD APPLE
					} else {
						g.setColor(badCol);
//						BAD APPLE
					}
					g.fillRect((i * handler.getWorld().GridPixelsize), (j * handler.getWorld().GridPixelsize),
							handler.getWorld().GridPixelsize, handler.getWorld().GridPixelsize);
				}

			}
		}

		paintComponent(g, 10, 45);////
	}

	public void Eat() {
		lenght++;
		Tail tail = null;
		handler.getWorld().appleLocation[xCoord][yCoord] = false;
		handler.getWorld().appleOnBoard = false;

		switch (direction) {
		case "Left":

			if (handler.getWorld().body.isEmpty()) {

				if (this.xCoord != handler.getWorld().GridWidthHeightPixelCount - 1) {
					tail = new Tail(this.xCoord + 1, this.yCoord, handler);
				} else {
					if (this.yCoord != 0) {
						tail = new Tail(this.xCoord, this.yCoord - 1, handler);
					} else {
						tail = new Tail(this.xCoord, this.yCoord + 1, handler);
					}
				}

			} else {
				if (handler.getWorld().body.getLast().x != handler.getWorld().GridWidthHeightPixelCount - 1) {
					tail = new Tail(handler.getWorld().body.getLast().x + 1, this.yCoord, handler);
				} else {
					if (handler.getWorld().body.getLast().y != 0) {
						tail = new Tail(handler.getWorld().body.getLast().x, this.yCoord - 1, handler);
					} else {
						tail = new Tail(handler.getWorld().body.getLast().x, this.yCoord + 1, handler);
					}
				}
			}

			break;
		case "Right":
			if (handler.getWorld().body.isEmpty()) {
				if (this.xCoord != 0) {
					tail = new Tail(this.xCoord - 1, this.yCoord, handler);
				} else {
					if (this.yCoord != 0) {
						tail = new Tail(this.xCoord, this.yCoord - 1, handler);
					} else {
						tail = new Tail(this.xCoord, this.yCoord + 1, handler);
					}
				}
			} else {
				if (handler.getWorld().body.getLast().x != 0) {
					tail = (new Tail(handler.getWorld().body.getLast().x - 1, this.yCoord, handler));
				} else {
					if (handler.getWorld().body.getLast().y != 0) {
						tail = (new Tail(handler.getWorld().body.getLast().x, this.yCoord - 1, handler));
					} else {
						tail = (new Tail(handler.getWorld().body.getLast().x, this.yCoord + 1, handler));
					}
				}

			}
			break;
		case "Up":
			if (handler.getWorld().body.isEmpty()) {
				if (this.yCoord != handler.getWorld().GridWidthHeightPixelCount - 1) {
					tail = (new Tail(this.xCoord, this.yCoord + 1, handler));
				} else {
					if (this.xCoord != 0) {
						tail = (new Tail(this.xCoord - 1, this.yCoord, handler));
					} else {
						tail = (new Tail(this.xCoord + 1, this.yCoord, handler));
					}
				}
			} else {
				if (handler.getWorld().body.getLast().y != handler.getWorld().GridWidthHeightPixelCount - 1) {
					tail = (new Tail(handler.getWorld().body.getLast().x, this.yCoord + 1, handler));
				} else {
					if (handler.getWorld().body.getLast().x != 0) {
						tail = (new Tail(handler.getWorld().body.getLast().x - 1, this.yCoord, handler));
					} else {
						tail = (new Tail(handler.getWorld().body.getLast().x + 1, this.yCoord, handler));
					}
				}

			}
			break;
		case "Down":
			if (handler.getWorld().body.isEmpty()) {
				if (this.yCoord != 0) {
					tail = (new Tail(this.xCoord, this.yCoord - 1, handler));
				} else {
					if (this.xCoord != 0) {
						tail = (new Tail(this.xCoord - 1, this.yCoord, handler));
					} else {
						tail = (new Tail(this.xCoord + 1, this.yCoord, handler));

//                       TEE VIII
					}
					System.out.println("Tu biscochito");
				}
			} else {
				if (handler.getWorld().body.getLast().y != 0) {
					tail = (new Tail(handler.getWorld().body.getLast().x, this.yCoord - 1, handler));
				} else {
					if (handler.getWorld().body.getLast().x != 0) {
						tail = (new Tail(handler.getWorld().body.getLast().x - 1, this.yCoord, handler));
					} else {
						tail = (new Tail(handler.getWorld().body.getLast().x + 1, this.yCoord, handler));
					}
				}

			}
			break;
		}
		handler.getWorld().body.addLast(tail);
		handler.getWorld().playerLocation[tail.x][tail.y] = true;
	}

	public void kill() {
		lenght = 0;
		for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
			for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {

				State.setState(handler.getGame().gameoverState);

//				put false in the following line to break game
				handler.getWorld().playerLocation[i][j] = false;

			}
		}

	}

	public boolean isJustAte() {
		return justAte;
	}

	public void setJustAte(boolean justAte) {
		this.justAte = justAte;
	}

	public static void paintComponent(Graphics g, int x, int y) {/////
//		text color
		Color c = new Color(4, 116, 60);
		g.setColor(c);

		g.setFont(new Font("Tahoma", Font.BOLD, 44));
		g.drawString("Score: " + trackscore, x, y);

	}
}
