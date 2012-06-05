package me.bored.pong.images;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class LoadTextures {

	public static Texture bg;
	public static Texture ball;
	public static Texture paddle;
	
	public static void LoadAll() {
		try {
			loadBg();
			loadBall();
			loadPaddle();
			System.out.println("BISON Loaded all textures!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void loadBg() throws IOException {
		bg = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/bg.png"));
	}
	
	private static void loadBall() throws IOException {
		ball = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ball.png"));
	}
	
	private static void loadPaddle() throws IOException {
		paddle = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/paddle.png"));
	}
	
}
