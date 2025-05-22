package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public class RectShape implements Shape{

    private int x;
    private int y;
   
    
    public RectShape() {
    	this.x = 0;
    	this.y = 0;
    }    
    
    public RectShape(RectShape outro) {
    	this.x = outro.x;
    	this.y = outro.y;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawRect(x, y, 40, 40);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
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
    public Shape clone() {
        return (Shape) new RectShape(this);
    }
}
