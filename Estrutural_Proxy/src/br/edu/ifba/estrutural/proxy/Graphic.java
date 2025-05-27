package br.edu.ifba.estrutural.proxy;

import java.awt.*;

interface Graphic {
    int getWidth();
    int getHeight();
    void forceDrawing();
    void draw(Graphics g, int x, int y);
}