package me.bored.pong.threads;

public abstract class BaseThreadManager implements ThreadManagerInterface {
	
	boolean active;
	protected BaseThread thread;
	
	public void startThread(){
		Runnable runnable = (Runnable) thread;
		Thread rthread = new Thread(runnable);
		rthread.start();
		active = true;
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void pauseThread(boolean pause){
		thread.pause(pause);		
	}
	
	public void stopThread(){
		thread.kill();
		active = false;
	}
	
}
