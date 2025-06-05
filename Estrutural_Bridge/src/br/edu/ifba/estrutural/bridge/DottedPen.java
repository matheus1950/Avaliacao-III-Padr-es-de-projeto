package br.edu.ifba.estrutural.bridge;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

class DottedPen implements Pen {
    @Override
    public void drawLine(Graphics g, int x, int y, int size, double angle) {
        int x2 = x + (int) (size * Math.cos(angle));
        int y2 = y + (int) (size * Math.sin(angle));
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dotted = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{1,2}, 0);
        g2d.setStroke(dotted);
        g2d.drawLine(x, y, x2, y2);
        g2d.dispose();
    }

    @Override
    public void drawCircle(Graphics g, int x, int y, int radius) {
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dotted = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, new float[]{1,2}, 0);
        g2d.setStroke(dotted);
        g2d.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g2d.dispose();
    }
}