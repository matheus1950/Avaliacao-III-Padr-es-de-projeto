package br.ifba.ads.inf011.framework;

import java.awt.Color;
import java.awt.Graphics2D;

public interface Graphic extends Clone {

	void draw(Graphics2D g2d);
	void initialize(int xInit, int yInit, int xEnd, int yEnd, Color corAtual);

}
