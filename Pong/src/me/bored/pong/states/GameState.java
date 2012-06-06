package me.bored.pong.states;

import me.bored.pong.Game;
import me.bored.pong.entity.BG;
import me.bored.pong.entity.Ball;
import me.bored.pong.entity.Paddle;
import me.bored.pong.images.LoadTextures;
import me.bored.pong.util.Fullscreen;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.CursorLoader;

public class GameState extends BaseState {
	
	protected Game game;
	
	private long lastFrame;
	
	int WIDTH, HEIGHT;
	
	Ball ball;
	BG bg;
	Paddle pad1;
	Paddle pad2;
	
    public GameState(Game game, int id) {
		super(id);
		this.game = game;
		WIDTH = game.dm.getWidth();
		HEIGHT = game.dm.getHeight();
	}
    
    private long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private int getDelta() {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }
      
    
	@Override
	public void init() {
		Mouse.setGrabbed(true);
		initGL();
		LoadTextures.LoadAll();
        ball = new Ball(game, 200, 100, 10, 10);
        pad1 = new Paddle(game, 0, 100, 10, 30);
        pad2 = new Paddle(game, 400, 100, 10, 30);
        bg = new BG(game, 0, 0, 600, 800);
	}

	@Override
	public void update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		bg.draw();
		
		handleInput();		
		handleBall();
		
		ball.draw();
		pad1.draw();
		pad2.draw();	

		ball.update(getDelta());
		pad1.update(getDelta());
		pad2.update(getDelta());
		
	    Display.update();
	    Display.sync(60);
	}
	
	private void handleBall(){
//		if(ball.getDX() == 0){
//	        ball.setDX(0.02);
//		}
//		if(ball.getDY() == 0){
//	        ball.setDY(0.02);
//		}
		if(ball.getY() > HEIGHT || ball.getY() < 0){
			ball.setDY(ball.getDY()*-1);
			if(ball.getDY() < 0){
				ball.setDY(ball.getDX() - 0.01);
			}else{
				ball.setDY(ball.getDX() + 0.01);
			}
		}
		if(ball.getX() > WIDTH || ball.getX() < 0){
			ball.setDX(ball.getDX()*-1);
			if(ball.getDX() < 0){
				ball.setDX(ball.getDX() - 0.01);
			}else{
				ball.setDX(ball.getDX() + 0.01);
			}
		}
		if(pad1.intersects(ball)){
	        ball.setDX((ball.getDX()*-1));
	        ball.setDY((ball.getDY()*-1));
			if(ball.getDX() < 0){
				ball.setDX(ball.getDX() - 0.01);
			}else{
				ball.setDX(ball.getDX() + 0.01);
			}
			if(ball.getDY() < 0){
				ball.setDY(ball.getDX() - 0.05);
			}else{
				ball.setDY(ball.getDX() + 0.05);
			}
		}
	}
	
	private void handleInput() {		
		pad1.setLocation(Mouse.getX(), Mouse.getY());
		if(pad1.getX() > WIDTH/2){
			pad1.setX(WIDTH/2);
			Mouse.setCursorPosition(WIDTH/2, Mouse.getY());
		}
	      while (Keyboard.next()) {
		      	 if (Keyboard.getEventKey() == Keyboard.KEY_F11) {
		          	    if (Keyboard.getEventKeyState()) {
		          	    	if(Fullscreen.fullscreen){
		          	    		Fullscreen.fullscreen = false;
		          	    		Fullscreen.setDisplayMode(WIDTH, HEIGHT, false);
		          	    	}else{
		          	    		Fullscreen.fullscreen = true;
		          	    		Fullscreen.setDisplayMode(WIDTH, HEIGHT, true);
		          	    	}
		          	    }
		      	 }
		  } 		
	}

	private void initGL(){
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
			Display.setTitle(game.dm.getTitle());
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, WIDTH, 0, HEIGHT, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);        
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING); 
		
		GL11.glClearColor(255f, 255f, 255f, 0f);                
		GL11.glClearDepth(1);
		
		GL11.glEnable(GL11.GL_BLEND);
      	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
      	
      	GL11.glViewport(0,0,WIDTH,HEIGHT);
      
      	GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		
	}
	
}