package br.edu.ifba.estrutural.adapter;

import java.awt.Graphics;

import br.edu.ifba.estrutural.external.Text;
import br.edu.ifba.estrutural.framework.Shape;

public class TextClasseAdapter extends Text implements Shape {

    private int x;
    private int y;
	
    public TextClasseAdapter(String content) {
        super(content);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        super.write(g, x, y);
        this.x = x;
        this.y = y;
    }    

    @Override
    public Shape clone() {
        TextClasseAdapter newAdapter = new TextClasseAdapter(this.getContent());
        newAdapter.setX(this.x); // Copia a posição
        newAdapter.setY(this.y);
        return newAdapter;
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}