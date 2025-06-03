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
        g.drawRect(this.getX()-this.getXSize()/2, this.getY()-this.getYSize()/2, this.getXSize(), this.getYSize());
    }    

    @Override
    public AbstractShape clone() {
        return (AbstractShape) new RectShape(this);
    }
}
