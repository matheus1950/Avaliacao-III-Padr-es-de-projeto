package br.edu.ifba.estrutural.bridge;

import java.awt.Graphics;

public class DrawShape {
    protected Pen pen;

    protected DrawShape(Pen pen) {
        this.pen = pen;
    }
    
    public void line(Graphics g, int x, int y, int size, double angle) {
    	this.pen.drawLine(g, x, y, size, angle);
    }
    
    public void circle(Graphics g, int x1, int y1, int size) {
    	this.pen.drawCircle(g, x1, y1, size);
    }
    
    public void innerCircle(Graphics g, int x1, int y1, int size) {
    	for(int i = 0; i < size; i+=5)
    		this.pen.drawCircle(g, x1, y1, i);
    }    

	public void setPen(Pen pen) {
		this.pen = pen;
	}    

}
