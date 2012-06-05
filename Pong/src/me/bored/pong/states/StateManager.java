package me.bored.pong.states;

import me.bored.pong.Game;
import me.bored.pong.entity.EntityManager;
import me.bored.pong.threads.StateThreadManager;

public class StateManager {
	
	public State activeState;
	StateThreadManager tm;	
	
	protected Game game;
	
    public StateManager(Game game) {
    	this.game = game;
    	tm = new StateThreadManager(game, activeState);
	}
	
    public void enterState(State state){
    	setActiveState(state);
    	EntityManager em = new EntityManager();
    	em.removeAll();
    	activeState = state;
    	if(tm.isActive()){
        	game.dm.clear();
    		tm.stop();
    	}
    	state.init();
    	tm.start();
    }
    
	public void setActiveState(State state){
		activeState = state;
    	tm = new StateThreadManager(game, activeState);
	}
	
	public State getActiveState(){
		return activeState;			
	}
    
}