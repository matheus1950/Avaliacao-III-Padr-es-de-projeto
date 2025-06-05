package br.edu.ifba.estrutural.bridge;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DashedPen implements Pen {
    @Override
    public void drawLine(Graphics g, int x, int y, int size, double angle) {
        int x2 = x + (int) (size * Math.cos(angle));
        int y2 = y + (int) (size * Math.sin(angle));
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(x, y, x2, y2);
        g2d.dispose();
    }

    @Override
    public void drawCircle(Graphics g, int x, int y, int radius) {
        Graphics2D g2d = (Graphics2D) g.create();
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g2d.dispose();
    }
}