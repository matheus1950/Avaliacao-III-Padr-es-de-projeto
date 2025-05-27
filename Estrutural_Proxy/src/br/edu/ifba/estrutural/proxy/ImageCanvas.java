package br.edu.ifba.estrutural.proxy;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

class ImageCanvas extends Canvas {
    private Graphic graphic; 

    public ImageCanvas() {
        this.graphic = null; 
        setPreferredSize(new Dimension(600, 400)); 
        setBackground(Color.WHITE); 
    }
    
    public void forceDrawing() {
    	this.graphic.forceDrawing();
    }

    public void setGraphic(Graphic graphic) {
        this.graphic = graphic;
    }

    @Override
    public void paint(Graphics g) {
        if (graphic != null) {
            graphic.draw(g, 10, 10);
        } else {
            g.setColor(Color.GRAY);
            g.drawString("Selecione uma imagem para desenhar", 50, 50);
        }
    }
}