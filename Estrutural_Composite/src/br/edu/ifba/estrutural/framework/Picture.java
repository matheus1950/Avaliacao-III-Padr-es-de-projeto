package br.edu.ifba.estrutural.framework;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Picture implements Shape {
    private List<Shape> children = new ArrayList<>();

    public void add(Shape shape) {
        this.children.add(shape);
    }

    public void remove(Shape shape) {
    	this.children.remove(shape);
    }

    @Override
    public void draw(Graphics g) {
        for (Shape shape : this.children) {
            shape.draw(g);
        }
    }
    
    @Override
    public int getX() {
        return (int) this.getCentroidX();
    }

    @Override
    public int getY() {
        return (int) this.getCentroidY();
    }
    
    @Override
    public int getXSize() {
        if (children.isEmpty()) return 0;

        int minX = children.get(0).getX() - children.get(0).getXSize() / 2;
        int maxX = children.get(0).getX() + children.get(0).getXSize() / 2;

        for (Shape shape : children) {
            minX = Math.min(minX, shape.getX() - shape.getXSize() / 2);
            maxX = Math.max(maxX, shape.getX() + shape.getXSize() / 2);
        }

        return maxX - minX;
    }
    
    

    private double getCentroidX() {
        if (children.isEmpty()) return 0;

        double sumX = 0;
        for (Shape shape : this.children) {
            sumX += shape.getX();
        }
        return sumX / this.children.size();
    }

    private double getCentroidY() {
        if (this.children.isEmpty()) return 0;

        double sumY = 0;
        for (Shape shape : this.children) {
            sumY += shape.getY();
        }
        return sumY / children.size();
    }
    


    @Override
    public int getYSize() {
        if (children.isEmpty()) return 0;

        int minY = children.get(0).getY() - children.get(0).getYSize() / 2;
        int maxY = children.get(0).getY() + children.get(0).getYSize() / 2;

        for (Shape shape : children) {
            minY = Math.min(minY, shape.getY() - shape.getYSize() / 2);
            maxY = Math.max(maxY, shape.getY() + shape.getYSize() / 2);
        }

        return maxY - minY;
    }


    @Override
    public Boolean contains(int x, int y) {
        for (Shape child : this.children) {
            if (child.contains(x, y))
                return true; // Retorna imediatamente se encontrar
        }
        return false;
    }

    @Override
    public void moveOffSet(int offSetX, int offSetY) {
        for (Shape child : this.children) {
            child.moveOffSet(offSetX, offSetY);
        }
    }

    @Override
    public Shape findShapeAt(int x, int y) {
        for (int i = children.size() - 1; i >= 0; i--) {
            Shape child = children.get(i);
            Shape found = child.findShapeAt(x, y);
            if (found != null) {
                return this;
            }
        }
        return null;
    }

    @Override
    public void move(int newX, int newY) {
        // Calcula o deslocamento necessário baseado no centroide
        double offsetX = newX - getCentroidX();
        double offsetY = newY - getCentroidY();

        // Move cada filho pelo deslocamento
        for (Shape child : children) {
            child.moveOffSet((int) offsetX, (int) offsetY);
        }
    }   
}