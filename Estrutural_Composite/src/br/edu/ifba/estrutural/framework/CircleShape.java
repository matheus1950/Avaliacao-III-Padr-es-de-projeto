package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public class CircleShape extends AbstractShape implements Shape{
    
    public CircleShape() {
    	super();
    }    
    
    public CircleShape(CircleShape outro) {
    	super(outro);
    }

    @Override
    public void doDraw(Graphics g) {
        g.drawOval(this.getX() - this.getXSize()/2, this.getY()-this.getYSize()/2, this.getXSize(), this.getYSize());
    }
    @Override
    public AbstractShape clone() {
        return (AbstractShape) new CircleShape(this);
    }
}    