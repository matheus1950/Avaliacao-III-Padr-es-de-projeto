package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public interface Shape extends Cloneable {
    public void draw(Graphics g);
    public int getX();
    public int getY();
    public int getSize();
    public void setX(int x);
    public void setY(int y);
    public void setSize(int size);
    public Shape clone(); 
}