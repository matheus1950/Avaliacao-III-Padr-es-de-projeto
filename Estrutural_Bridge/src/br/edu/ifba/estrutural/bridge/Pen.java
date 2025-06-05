package br.edu.ifba.estrutural.bridge;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Implementador (Implementor)
public interface Pen {
	void drawLine(Graphics g, int x, int y, int size, double angle);
    void drawCircle(Graphics g, int x, int y, int radius);
}