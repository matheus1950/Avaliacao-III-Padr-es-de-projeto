package br.edu.ifba.estrutural.proxy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image implements Graphic {
    private BufferedImage image;
    private String filename;
    private Boolean drawing;

    public Image(String filename) {
        this.filename = filename;
        this.drawing = Boolean.TRUE;
        loadImage();
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.err.println("Erro ao carregar a imagem: " + filename);
            image = null; // ou uma imagem placeholder
            e.printStackTrace();
        }
    }

    @Override
    public int getWidth() {
        return (image != null) ? image.getWidth() : 0;
    }

    @Override
    public int getHeight() {
        return (image != null) ? image.getHeight() : 0;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        if (image != null && drawing) {
            g.drawImage(image, x, y, null);
        } else {
            g.drawString("Imagem não carregada", x, y);
        }
    }

	@Override
	public void forceDrawing() {
		this.drawing = Boolean.TRUE;
	}
}