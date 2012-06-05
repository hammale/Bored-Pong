package me.bored.pong.states;

public abstract class BaseState implements State {
	
	protected int id;
	
	public BaseState(int id){
		this.id = id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
}
