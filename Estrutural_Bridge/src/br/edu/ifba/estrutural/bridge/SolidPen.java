package br.edu.ifba.estrutural.bridge;

import java.awt.Graphics;

class SolidPen implements Pen {
    @Override
    public void drawLine(Graphics g, int x, int y, int size, double angle) {
        int x2 = x + (int) (size * Math.cos(angle));
        int y2 = y + (int) (size * Math.sin(angle));
        g.drawLine(x, y, x2, y2);
    }

    @Override
    public void drawCircle(Graphics g, int x, int y, int radius) {
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}
