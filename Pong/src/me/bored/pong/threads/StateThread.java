package me.bored.pong.threads;

import me.bored.pong.states.State;

public class StateThread extends BaseThread implements Runnable {
		
	protected State state;
	
	public StateThread(State state){
		this.state = state;
	}
	
	@Override
	public void run() {
        while (running) {
			while (paused){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			state.update();
        }
	}
	
}