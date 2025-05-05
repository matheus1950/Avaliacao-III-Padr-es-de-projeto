package br.ifba.ads.inf011.framework.tool;


import java.awt.event.MouseListener;
import java.util.List;

import br.ifba.ads.inf011.framework.ButtonTool;
import br.ifba.ads.inf011.framework.Graphic;
import br.ifba.ads.inf011.framework.GraphicSymbol;

public class GraphicTool extends ButtonTool implements Tool,  MouseListener {
    
    public GraphicTool(List<Graphic> graphics){
    	super("Graphic", graphics);
    }

	@Override
	public void manipulate() {
		GraphicSymbol graphic = new GraphicSymbol(this.xInicial, this.yInicial,  100, 100, this.color);
		this.graphics.add(graphic);
	}
	

}
