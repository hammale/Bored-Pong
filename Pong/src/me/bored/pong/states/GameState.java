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
		initGL();
		LoadTextures.LoadAll();
        try {
            Cursor cursor = (CursorLoader.get()).getCursor("res/cursor.png",0,0);
			Mouse.setNativeCursor(cursor);
		} catch (Exception e) {
			e.printStackTrace();
		}
        ball = new Ball(game, 400, 100, 36, 14);
        bg = new BG(game, 0, 0, 600, 800);
        bg.draw();
        ball.draw();
	}

	@Override
	public void update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		handleInput();
		bg.draw();
		
		ball.draw();
		ball.update(getDelta());
		
	    Display.update();
	    Display.sync(60);
	}
	
	private void handleInput() {
		pad1.setDX(0);
		pad1.setDY(0);
		pad2.setDX(0);
		pad2.setDY(0);
		//paddle 1
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){

		}
		//paddle 2
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){

		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
		
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
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
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