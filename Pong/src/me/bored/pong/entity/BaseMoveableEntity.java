package me.bored.pong.entity;

import me.bored.pong.Game;

public abstract class BaseMoveableEntity extends BaseEntity implements MoveableEntity {
	
	protected double dx ,dy;
	
	public BaseMoveableEntity(Game game, double x, double y, double width, double height) {
		super(game, x, y, width, height);
        this.dx = 0;
        this.dy = 0;
	}

    @Override
    public void update(int delta) {
            this.x += delta * dx;
            this.y += delta * dy;
    }
    
    public double getDX() {
            return dx;
    }
    
    public double getDY() {
            return dy;
    }
    
    public void setDX(double dx) {
            this.dx = dx;
    }
    
    public void setDY(double dy) {
            this.dy = dy;
    }
	
}