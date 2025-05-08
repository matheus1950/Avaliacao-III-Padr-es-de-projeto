package br.ifba.ads.inf011.model;

import java.awt.Color;
import java.awt.Graphics2D;

import br.ifba.ads.inf011.framework.Clone;
import br.ifba.ads.inf011.framework.Graphic;

public abstract class AbstractGraphicSymbol implements Graphic{
	
	protected int xInit;
	protected int yInit;
	protected int xEnd;
	protected int yEnd;	
	protected Color corAtual;
	
	public AbstractGraphicSymbol() {
		this(0, 0, 0, 0, Color.BLACK);
	}
	
	public AbstractGraphicSymbol(int xInit, int yInit, int xEnd, int yEnd, Color corAtual) {
		this.initialize(xInit, yInit, xEnd, yEnd, corAtual);
	}
	
	public void initialize (int xInit, int yInit, int xEnd, int yEnd, Color corAtual) {
		this.xInit = xInit;
		this.yInit = yInit;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.corAtual = corAtual;
		
	}	



}
