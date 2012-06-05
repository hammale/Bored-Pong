package me.bored.pong.threads;

public abstract class BaseThread implements ThreadInterface {
	
	boolean running = true;
	boolean paused;
	
	@Override
	 public void kill() {
		running = false;
	}
	
	@Override
	public boolean getPaused(){
		return paused;
	}
	
	@Override
	public void pause(boolean paused) {
		this.paused = paused;
		
	}
	
}