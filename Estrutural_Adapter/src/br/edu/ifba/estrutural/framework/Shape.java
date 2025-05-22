package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public interface Shape extends Cloneable {
    public void draw(Graphics g, int x, int y);
    public int getX();
    public int getY();
    public void setX(int x);
    public void setY(int y);
    public Shape clone(); 
}