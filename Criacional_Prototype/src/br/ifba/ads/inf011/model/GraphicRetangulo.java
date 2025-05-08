package br.ifba.ads.inf011.model;

import java.awt.Color;
import java.awt.Graphics2D;

import br.ifba.ads.inf011.framework.Clone;
import br.ifba.ads.inf011.framework.Graphic;

public class GraphicRetangulo extends AbstractGraphicSymbol implements Graphic{
	

	public GraphicRetangulo() {
		super(0, 0, 0, 0, Color.BLACK);
	}
	
	
	public GraphicRetangulo(int xInit, int yInit, int xEnd, int yEnd, Color corAtual) {
		super(xInit, yInit, xEnd, yEnd, corAtual);
	}
	

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.corAtual);
		g2d.drawRoundRect(this.xInit, this.yInit, 100, 100, 5, 5);
	}

	@Override
	public Clone clonar() {
		return new GraphicRetangulo(this.xInit, this.yInit, 
				 this.xEnd, this.yEnd,
				 this.corAtual);
	}
	


}
