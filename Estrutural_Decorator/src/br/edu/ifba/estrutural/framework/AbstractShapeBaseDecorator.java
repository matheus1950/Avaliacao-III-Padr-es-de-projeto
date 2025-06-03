package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public abstract class AbstractShapeBaseDecorator implements Shape{
	
	protected Shape shape; 

	public AbstractShapeBaseDecorator(Shape shape) {
	    this.shape = shape;
	}

	@Override
	public int getX() {
	    return shape.getX(); // Delega para a forma original
	}
	
	@Override
	public int getY() {
	    return shape.getY(); // Delega para a forma original
	}
	
	@Override
	public void setX(int x) {
	    shape.setX(x); // Delega para a forma original
	}
	
	@Override
	public void setY(int y) {
	    shape.setY(y); // Delega para a forma original
	}

	@Override
	public int getSize() {
		return shape.getSize();
	}

	@Override
	public void setSize(int size) {
		shape.setSize(size);
	}

	@Override
	public void draw(Graphics g) {
		this.shape.draw(g);
		
	}
	
	@Override
	public abstract Shape clone();


	
}	
