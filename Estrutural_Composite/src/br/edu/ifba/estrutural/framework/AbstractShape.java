package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public abstract class AbstractShape implements Shape, Cloneable{

    private int x;
    private int y;
    private int xSize;
    private int ySize;
    
    public AbstractShape() {
    	this.x = 0;
    	this.y = 0;
    	this.xSize = 20;
    	this.ySize = 20;
    }    
    
    public AbstractShape(int x, int y, int xSize, int ySize) {
    	this.x = x;
    	this.y = y;
    	this.xSize = xSize;
    	this.ySize = ySize;
    }      
    
    public AbstractShape(AbstractShape outro) {
    	this.x = outro.x;
    	this.y = outro.y;
    	this.xSize = outro.xSize;
    	this.ySize = outro.ySize;
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
    public int getYSize() {
    	return this.ySize;
    }

    
    @Override
    public int getXSize() {
    	return this.xSize;
    }
    
    public Boolean contains(int x, int y) {
         int xSize = this.getXSize();
         int ySize = this.getYSize();
         return (x >= this.getX() - xSize / 2 && x <= this.getX() + xSize / 2 &&
                y >= this.getY() - ySize / 2 && y <= this.getY() + ySize / 2);
    }    
    
    @Override
    public void moveOffSet(int offSetX, int offSetY) {
        this.x = this.getX() + offSetX;
        this.y = this.getY() + offSetY;
    }
    
    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }    

    @Override
    public Shape findShapeAt(int x, int y) {
        if (this.contains(x, y)) {
            return this;
        }
        return null;
    }  
    

    public abstract AbstractShape clone();
}
