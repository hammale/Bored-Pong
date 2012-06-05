package me.bored.pong.entity;

import me.bored.pong.Game;
import me.bored.pong.images.LoadTextures;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class BG extends BaseEntity {
	
	Texture bg;
	
	public BG(Game game, double x, double y, double width, double height) {
        super(game, x, y, width, height);
    }
    
    @Override
    public void draw() {
    	bg = LoadTextures.bg;
        bg.bind();
        GL11.glLoadIdentity();
        GL11.glTranslated(x, y, 0);
    	GL11.glBegin(GL11.GL_QUADS);
    	
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(0,0);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(bg.getTextureWidth(),0);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(bg.getTextureWidth(),bg.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(0,bg.getTextureHeight());
		GL11.glEnd();
		GL11.glLoadIdentity();
		
    }

	@Override
	public void update(int delta) {
		
	}

	
}