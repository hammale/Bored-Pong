package me.bored.pong.entity;

import me.bored.pong.Game;
import me.bored.pong.images.LoadTextures;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
	
public class Paddle extends BaseMoveableEntity {
		
	Texture paddle;
	
        public Paddle(Game game, double x, double y, double width, double height) {
            super(game, x, y, width, height);
            paddle = LoadTextures.paddle;
        }
        
        @Override
        public void draw() {
        	paddle.bind();
            GL11.glLoadIdentity();
            GL11.glTranslated(x, y, 0);
            drawQuad();
        }
        
        public void drawQuad(){
        	GL11.glBegin(GL11.GL_QUADS);
    				GL11.glTexCoord2f(0,0);
    			GL11.glVertex2f(0,0);
    				GL11.glTexCoord2f(1,0);
    			GL11.glVertex2f(paddle.getTextureWidth(),0);
    				GL11.glTexCoord2f(1,1);
    			GL11.glVertex2f(paddle.getTextureWidth(),paddle.getTextureHeight());
    				GL11.glTexCoord2f(0,1);
    			GL11.glVertex2f(0,paddle.getTextureHeight());
    		GL11.glEnd();
    		 GL11.glLoadIdentity();
        }
}