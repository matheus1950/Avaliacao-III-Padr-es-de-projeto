package br.edu.ifba.estrutural.proxy;

import java.awt.Color;
import java.awt.Graphics;

public class ImageProxy implements Graphic {
	
    private String filename;
    private int width;
    private int height;
    private Image image;
    
    private Boolean drawing;

    public ImageProxy(String filename) {
        this.filename = filename;
        this.width = 50; 
        this.height = 50;
        this.drawing = Boolean.FALSE;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
    	
    	if(!drawing) {
            g.setColor(Color.GRAY);
    		g.drawString("Imagem: " + filename + " selecionada...", 50, 50);
    		g.drawString("Aguardando necessidade de desenho...", 50, 75);
    		return;
    	}	
    	
        if (image == null ) {
            System.out.println("Carregando imagem: " + filename);
            image = new Image(filename);
            width = image.getWidth(); //Atualiza as dimensões com o valor real
            height = image.getHeight();
        }
        image.draw(g, x, y);
    }

	@Override
	public void forceDrawing() {
		this.drawing = Boolean.TRUE;
		
	}
}