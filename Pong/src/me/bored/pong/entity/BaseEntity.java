package me.bored.pong.entity;

import java.awt.Rectangle;

import me.bored.pong.Game;

public abstract class BaseEntity implements Entity {
	
	protected double x, y, width, height;
    protected Rectangle hitbox = new Rectangle();
    protected int id;
    protected Game game;
    protected EntityManager em;
    protected Entity entity;
    
    public BaseEntity(Game game, double x, double y, double width, double height) {
    		em = new EntityManager();
    		this.game = game;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.entity = this;
    }
    
    @Override
    public void update(int delta){
    	
    }
    
    @Override
    public int getId(){
    	return this.id;
    }
    
    @Override
    public void destroy(){
    	em.remove(entity);
    }
    
    @Override
    public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
    }

    @Override
    public void setX(double x) {
            this.x = x;
    }
            
    @Override
    public void setY(double y) {
            this.y = y;
    }

    @Override
    public void setWidth(double width) {
            this.width = width;
    }

    @Override
    public void setHeight(double height) {
            this.height = height;
    }

    @Override
    public double getX() {
            return x;
    }

    @Override
    public double getY() {
            return y;
    }

    @Override
    public double getHeight() {
            return height;
    }

    @Override
    public double getWidth() {
            return width;
    }

    @Override
    public boolean intersects(Entity other) {
            hitbox.setBounds((int) x, (int) y, (int) width, (int) height);
            return hitbox.intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
    }
    
}