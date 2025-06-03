package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Picture2 implements Shape {
    private List<Shape> children = new ArrayList<>();

    public void add(Shape shape) {
        children.add(shape);
    }

    public void remove(Shape shape) {
        children.remove(shape);
    }

    @Override
    public void draw(Graphics g) {
        for (Shape shape : children) {
            shape.draw(g); // Desenha cada forma relativa à Picture
        }
    }

    private int minX() {
    	int x = children.size() > 0 ? children.get(0).getX() : 0;
        for (Shape shape : children)
            if(shape.getX() < x)
            	x = shape.getX();
        return x;    	
    }
    
    private int maxX() {
    	int x = children.size() > 0 ? children.get(0).getX() : Integer.MAX_VALUE;
        for (Shape shape : children)
            if(shape.getX() > x)
            	x = shape.getX();
        return x;    	
    }
    
    private int minY() {
    	int y = children.size() > 0 ? children.get(0).getY() : 0;
        for (Shape shape : children)
            if(shape.getY() < y)
            	y = shape.getY();
        return y;    	
    }
    
    private int maxY() {
    	int y = children.size() > 0 ? children.get(0).getY() : Integer.MAX_VALUE;
        for (Shape shape : children)
            if(shape.getY() > y)
            	y = shape.getY();
        return y;    	
    }
    
    @Override
    public int getX() {
        return this.minX();
    }

    @Override
    public int getY() {
    	return this.minY();
    }

    
    @Override
    public int getXSize() {
    	return this.maxX() - this.minX();
    }
    
    @Override
    public int getYSize() {
    	return this.maxX() - this.minX();
    }
	
	public Boolean contains(int x, int y) {
		for(Shape child : this.children) {
			if(child.contains(x, y))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}	
    
    @Override
    public void moveOffSet(int offSetX, int offSetY) {
        for(Shape child : this.children) {
            child.moveOffSet(offSetX, offSetY);
        }
    }
    
    @Override
    public Shape findShapeAt(int x, int y) {
        for (int i = children.size() - 1; i >= 0; i--) {
            Shape child = children.get(i);
            Shape found = child.findShapeAt(x, y);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

	@Override
	public void move(int x, int y) {
		int xBase = this.minX();
		int yBase = this.minY();
		this.moveOffSet(x - xBase, y - yBase);
	}    
    
	
}