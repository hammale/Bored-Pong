package me.bored.pong.display;

import me.bored.pong.Game;

import org.lwjgl.opengl.GL11;

public class DisplayManager {
	
	protected int width, height;
	protected String title;
	protected Game game;
	
	public DisplayManager(Game game, int width, int height, String title){
		this.width = width;
		this.height = height;
		this.title = title;
		this.game = game;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getHeight(){
		return this.width;
	}
	
	public int getWidth(){
		return this.height;
	}

	public void clear() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}
	
}
