package me.bored.pong.threads;

import me.bored.pong.Game;
import me.bored.pong.states.State;

import org.lwjgl.opengl.Display;

public class StateThreadManager {
	
	protected State activeState;
	protected Game game;
	
	public StateThreadManager(Game game, State activeState){
		this.activeState = activeState;
		this.thread = new StateThread(activeState);
		this.game = game;
	}
	
	boolean running;
	boolean paused;
	
	protected StateThread thread;
	
	public void start(){
		running = true;
		while(running){
			while(!paused){
				if(Display.isCloseRequested()){
					game.save();
					Display.destroy();
					System.exit(0);
				}
				activeState.update();
			}
		}
	}
	
	public boolean isActive(){
		return running;
	}

	public void pause(boolean pause){
		paused = pause;		
	}
	
	public void stop(){
		running = false;
	}
	
}