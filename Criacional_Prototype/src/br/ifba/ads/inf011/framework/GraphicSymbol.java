package br.ifba.ads.inf011.framework;

import java.awt.Color;
import java.awt.Graphics2D;

public class GraphicSymbol implements Graphic{
	
	private int xInit;
	private int yInit;
	private int xEnd;
	private int yEnd;	
	private Color corAtual;
	
	public GraphicSymbol(int xInit, int yInit, int xEnd, int yEnd, Color corAtual) {
		this.xInit = xInit;
		this.yInit = yInit;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.corAtual = corAtual;
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.corAtual);
		g2d.drawOval(this.xInit, this.yInit, xEnd, yEnd);
	}
	


}
