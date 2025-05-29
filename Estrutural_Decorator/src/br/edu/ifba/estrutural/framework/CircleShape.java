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
        g.drawOval(this.getX() - this.getSize()/2, this.getY()-this.getSize()/2, this.getSize(), this.getSize());
    }
    @Override
    public Shape clone() {
        return (Shape) new CircleShape(this);
    }
}    