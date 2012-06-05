package me.bored.pong.entity;

import me.bored.pong.Game;
import me.bored.pong.images.LoadTextures;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
	
public class Ball extends BaseMoveableEntity {
		
	Texture ball;
	
        public Ball(Game game, double x, double y, double width, double height) {
            super(game, x, y, width, height);
            ball = LoadTextures.ball;
        }
        
        @Override
        public void draw() {
        	ball.bind();
            GL11.glLoadIdentity();
            GL11.glTranslated(x, y, 0);
            drawQuad();
        }
        
        public void drawQuad(){
        	GL11.glBegin(GL11.GL_QUADS);
    				GL11.glTexCoord2f(0,0);
    			GL11.glVertex2f(0,0);
    				GL11.glTexCoord2f(1,0);
    			GL11.glVertex2f(ball.getTextureWidth(),0);
    				GL11.glTexCoord2f(1,1);
    			GL11.glVertex2f(ball.getTextureWidth(),ball.getTextureHeight());
    				GL11.glTexCoord2f(0,1);
    			GL11.glVertex2f(0,ball.getTextureHeight());
    		GL11.glEnd();
    		 GL11.glLoadIdentity();
        }

        @Override
        public void update(int delta) {
                this.x += delta * dx;
                this.y += delta * dy;
        }
}