package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public abstract class AbstractShape implements Shape{

    private int x;
    private int y;
    private int size;
   
    
    public AbstractShape() {
    	this.x = 0;
    	this.y = 0;
    	this.size = 20;
    }    
    
    public AbstractShape(int x, int y, int size) {
    	this.x = x;
    	this.y = y;
    	this.size = size;
    }      
    
    public AbstractShape(AbstractShape outro) {
    	this.x = outro.x;
    	this.y = outro.y;
    	this.size = outro.size;
    }

    @Override
    public void draw(Graphics g) {
        this.doDraw(g);
    }
    
    public abstract void doDraw(Graphics g);

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public void setSize(int size) {
        this.size = size;
    }
    
    
    @Override
    public int getSize() {
    	return this.size;
    }

    public abstract Shape clone();
}
