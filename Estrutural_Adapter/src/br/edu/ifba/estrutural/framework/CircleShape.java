package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public class CircleShape implements Shape{

    private int x;
    private int y;
    
    public CircleShape() {
    	this.x = 20;
    	this.y = 20;
    }    
    
    public CircleShape(CircleShape outro) {
    	this.x = outro.x;
    	this.y = outro.y;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawOval(x-20, y-20, 20, 20);
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
        return (Shape) new CircleShape(this);
    }
}    