package br.edu.ifba.estrutural.bridge;

import java.awt.Graphics;

public class AdvancedDrawShape extends DrawShape {
    public AdvancedDrawShape(Pen pen) {
        super(pen);
    }

    public void star(Graphics g, int x, int y, int size) {
        for (int i = 0; i < 5; i++) {
            double angle = 2 * Math.PI / 5 * i - Math.PI / 2;
            this.line(g, x, y, size, angle);
        }
    }

    public void stickFigure(Graphics g, int x, int y, int headSize) {
        // Cabeça
        this.circle(g, x, y, headSize);
        // Corpo
        this.line(g, x, y + headSize, headSize * 2, Math.PI / 2);
        // Braços
        this.line(g, x, (int) (y + headSize * 1.5), headSize, 0);
        this.line(g, x, (int) (y + headSize * 1.5), headSize, Math.PI);
        // Pernas
        this.line(g, x, y + headSize * 3, (int) (headSize * 1.5), Math.PI / 4);
        this.line(g, x, y + headSize * 3, (int) (headSize * 1.5), Math.PI * 3 / 4);
    }
    
  
}