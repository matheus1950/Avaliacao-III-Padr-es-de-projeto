package br.edu.ifba.estrutural.adapter;

import java.awt.Graphics;

import br.edu.ifba.estrutural.external.Text;
import br.edu.ifba.estrutural.framework.Shape;

public class TextObjectAdapter implements Shape {
    private Text text;
    private int x;
    private int y;

    public TextObjectAdapter(Text text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        text.write(g, x, y);
        this.x = x;
        this.y = y;
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

    @Override
    public Shape clone() {
        Text newText = new Text(this.text.getContent());
        TextObjectAdapter newAdapter = new TextObjectAdapter(newText);
        newAdapter.setX(this.x); // Copia a posição
        newAdapter.setY(this.y);
        return newAdapter;
    }
}