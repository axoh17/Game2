package axohEngine2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;

import axohEngine2.entities.AnimatedSprite;
import axohEngine2.entities.ImageEntity;
import axohEngine2.entities.SpriteSheet;

public class Judgement extends Game {
	private static final long serialVersionUID = 1L;
	
	static int SCREENWIDTH = 1600;
	static int SCREENHEIGHT = 900;
	int scale = 4;
	static int CENTERX = SCREENWIDTH / 2;
	static int CENTERY = SCREENHEIGHT / 2;
	
	//Sprite states
	static int SPRITE_NORMAL = 0;
	static int SPRITE_COLLIDED = 1;
	
	boolean showBounds = true;
	boolean collisionTesting = true;
	long collisionTimer = 0;
	
	Random random = new Random();
	//Collections collection;
	
	ImageEntity background;
	AnimatedSprite grass;
	AnimatedSprite player1;
	
	SpriteSheet sheet;
	SpriteSheet player;
			
	int frameCount = 0, frameRate = 0;
	long startTime = System.currentTimeMillis();
	
	boolean keyLeft, keyRight, keyUp, keyDown, keyInventory, keyAction, keyBack, keyEnter;
	
	//Load Sound effects
	public Judgement() {
		super(60, SCREENWIDTH, SCREENHEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	void gameStartUp() {
		//Initialize spriteSheets
		sheet = new SpriteSheet("/textures/environments/environments1.png", 16, 16, 16);
		player = new SpriteSheet("/textures/characters/mainCharacter.png", 8, 8, 32);

		grass = new AnimatedSprite(this, graphics());
		player1 = new AnimatedSprite(this, graphics());
		
		background = new ImageEntity(this);
		background.load("/field.png");
		
		player1.setAnimSprite(player, 40);
		player1.loadAnim(4, 3);

		sprites().add(player1);
		sprites().add(grass);
		grass.setAnimSprite(sheet, 1);
		grass.loadAnim(0, 0);
		//collection = new Collections();
		//collection.Initialize();
		
		requestFocus();
		start();
	}

	void gameTimedUpdate() {
		checkInput();
	}

	void gameRefreshScreen() {		
		Graphics2D g2d = graphics();
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Arial", Font.PLAIN, 48));
        g2d.drawImage(background.getImage(), 0, 0, SCREENWIDTH-1, SCREENHEIGHT-1, this);
        
        if(keyLeft) g2d.drawString("left!", 100, 100);
        if(keyRight) g2d.drawString("Right!", 200, 100);
        if(keyDown) g2d.drawString("Down!", 300, 100);
        if(keyUp) g2d.drawString("Up!", 400, 100);
        
        g2d.drawImage(grass.getAnimImage(), 100, 100, 16 * scale, 16 * scale, this);
        g2d.drawImage(player1.getAnimImage(), 150, 150, 32 * scale, 32 * scale, this);
	}

	void gameShutDown() {		
	}

	void spriteUpdate(AnimatedSprite sprite) {		
	}

	void spriteDraw(AnimatedSprite sprite) {		
	}

	void spriteDying(AnimatedSprite sprite) {		
	}

	void spriteCollision(AnimatedSprite spr1, AnimatedSprite spr2) {		
	}
	
	//Main
	public static void main(String[] args) {
		new Judgement();
	}
	
	/**********************************************************
	 * 
	 * 
	 *             Key events - Mouse events
	 *                            
	 ***********************************************************/
	public void checkInput() {
		if(keyLeft) System.out.println("Left");
	}
	
	void gameKeyDown(int keyCode) {
		switch(keyCode) {
        case KeyEvent.VK_LEFT:
            keyLeft = true;
            break;
        case KeyEvent.VK_RIGHT:
            keyRight = true;
            break;
        case KeyEvent.VK_UP:
            keyUp = true;
            break;
        case KeyEvent.VK_DOWN:
            keyDown = true;
            break;
        case KeyEvent.VK_I:
        	keyInventory = true;
        	break;
        case KeyEvent.VK_E:
        	keyAction = true;
        	break;
        case KeyEvent.VK_ENTER:
        	keyEnter = true;
        	break;
        case KeyEvent.VK_BACK_SPACE:
        	keyBack = true;
        	break;
        }
	}

	void gameKeyUp(int keyCode) {
		switch(keyCode) {
        case KeyEvent.VK_LEFT:
            keyLeft = false;
            break;
        case KeyEvent.VK_RIGHT:
            keyRight = false;
            break;
        case KeyEvent.VK_UP:
            keyUp = false;
            break;
        case KeyEvent.VK_DOWN:
            keyDown = false;
            break;
        case KeyEvent.VK_I:
	    	keyInventory = false;
	    	break;
	    case KeyEvent.VK_E:
	    	keyAction = false;
	    	break;
	    case KeyEvent.VK_ENTER:
	    	keyEnter = false;
	    	break;
	    case KeyEvent.VK_BACK_SPACE:
	    	keyBack = false;
	    	break;
		}
	}

	void gameMouseDown() {		
	}

	void gameMouseUp() {		
	}

	void gameMouseMove() {
	}
}