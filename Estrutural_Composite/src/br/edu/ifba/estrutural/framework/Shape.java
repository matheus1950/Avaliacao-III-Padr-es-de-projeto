package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public interface Shape {
    public void draw(Graphics g);
    public int getX();
    public int getY();
    public int getXSize();
    public int getYSize();
    public void moveOffSet(int offSetX, int offSetY);
    public void move(int offSetX, int offSetY);
    public  Boolean contains(int x, int y); 
    public Shape findShapeAt(int x, int y);
}