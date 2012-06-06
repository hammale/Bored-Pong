package me.bored.pong;

import me.bored.pong.display.DisplayManager;
import me.bored.pong.states.GameState;
import me.bored.pong.states.StateManager;

public class Game {
	
	public DisplayManager dm;
	StateManager sm;
	static Thread mainThread;
	
	public Game(int width, int height, String title){
		System.out.println("BISON by hammale & gyroninja enabled!");
		dm = new DisplayManager(this, width, height, title);
		initState();
	}
	
	private void initState(){
		sm = new StateManager(this);
		sm.enterState(new GameState(this, 0));
	}
	
	public static void main(String[] argv) {
		mainThread = Thread.currentThread();
		new Game(300, 400, "Bored Pong");
	}

	public void save() {

	}
	
}