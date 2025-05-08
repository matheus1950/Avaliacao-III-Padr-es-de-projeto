package br.ifba.ads.inf011.model;

import java.awt.Color;
import java.awt.Graphics2D;

import br.ifba.ads.inf011.framework.Clone;
import br.ifba.ads.inf011.framework.Graphic;

public class GraphicOval extends AbstractGraphicSymbol implements Graphic{
	

	public GraphicOval() {
		super();
	}
	
	
	public GraphicOval(int xInit, int yInit, int xEnd, int yEnd, Color corAtual) {
		super(xInit, yInit, xEnd, yEnd, corAtual);
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.corAtual);
		g2d.drawOval(this.xInit, this.yInit, xEnd, yEnd);
	}

	@Override
	public Clone clonar() {
		return new GraphicOval(this.xInit, this.yInit, 
								 this.xEnd, this.yEnd,
								 this.corAtual);
	}


}
