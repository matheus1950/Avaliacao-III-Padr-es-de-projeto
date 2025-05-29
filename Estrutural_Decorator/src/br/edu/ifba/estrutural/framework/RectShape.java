package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public class RectShape extends AbstractShape implements Shape{

    public RectShape() {
    	super();
    }    
    
    public RectShape(RectShape outro) {
    	super(outro);
    }

    @Override
    public void doDraw(Graphics g) {
        g.drawRect(this.getX()-this.getSize()/2, this.getY()-this.getSize()/2, this.getSize(), this.getSize());
    }    

    @Override
    public Shape clone() {
        return (Shape) new RectShape(this);
    }
}
