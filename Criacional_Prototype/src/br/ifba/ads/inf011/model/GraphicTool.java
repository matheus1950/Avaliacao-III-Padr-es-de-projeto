package br.ifba.ads.inf011.model;


import java.awt.event.MouseListener;
import java.util.List;

import br.ifba.ads.inf011.framework.ButtonTool;
import br.ifba.ads.inf011.framework.Clone;
import br.ifba.ads.inf011.framework.Graphic;
import br.ifba.ads.inf011.framework.tool.Tool;

public class GraphicTool extends ButtonTool implements Tool,  MouseListener {

	private Graphic graphic;
	
    public GraphicTool(String toolName, List<Graphic> graphics, Graphic clone){
    	super(toolName, graphics);
    	this.graphic = clone;
    }

	@Override
	public void manipulate() {
		Graphic newGraphic = (Graphic) this.graphic.clonar();
		newGraphic.initialize(this.xInicial, this.yInicial, 100, 100, this.color);
		this.graphics.add(newGraphic);
	}
	
	
	

}
