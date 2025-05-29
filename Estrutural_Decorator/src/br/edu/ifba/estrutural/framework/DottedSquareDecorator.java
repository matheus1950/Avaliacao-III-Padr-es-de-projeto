package br.edu.ifba.estrutural.framework;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DottedSquareDecorator extends AbstractShapeBaseDecorator implements ShapeDecorator {


    public DottedSquareDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = this.setDashedStroke(g);
        int size = this.getSize();
        g2d.drawRect(this.getX() - size/2, this.getY() - size/2, size, size);
        g2d.setStroke(new BasicStroke()); 
    }
    
    private Graphics2D setDashedStroke(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0); // Define o padrão de pontilhado
        g2d.setStroke(dashed);
        return g2d;
    }
    
    
    public int getSize() {
    	return super.getSize() + 10;
    }

    @Override
    public Shape clone() {
        return new DottedSquareDecorator(shape.clone()); // Clona o decorator e a forma interna
    }


}