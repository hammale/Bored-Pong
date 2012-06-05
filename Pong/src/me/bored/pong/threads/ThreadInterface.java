package me.bored.pong.threads;

public interface ThreadInterface {

	public boolean getPaused();
	public void pause(boolean paused);
	public void kill();

}
