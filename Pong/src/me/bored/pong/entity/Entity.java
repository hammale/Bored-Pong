package me.bored.pong.entity;

public interface Entity {
	
	public void update(int delta);
	public void destroy();
    public int getId();
    public void draw();
    public void setLocation(double x, double y);
    public void setX(double x);
    public void setY(double y);
    public void setWidth(double width);
    public void setHeight(double height);
    public double getX();
    public double getY();
    public double getHeight();
    public double getWidth();
    public boolean intersects(Entity other);
	
}
