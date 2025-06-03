package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;

public class LineShape extends AbstractShape implements Shape{

    public LineShape() {
    	super();
    }    
    
    public LineShape(LineShape outro) {
    	super(outro);
    }	
	
	@Override
	public void doDraw(Graphics g) {
		g.drawLine(this.getX() - this.getXSize()/2, this.getY()-this.getYSize()/2, this.getX()+this.getXSize()/2, this.getY()+this.getYSize()/2);
	}

	@Override
	public AbstractShape clone() {
		 return (AbstractShape) new LineShape(this);
	}

}
