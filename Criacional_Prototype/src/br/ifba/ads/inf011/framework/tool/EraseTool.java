package br.ifba.ads.inf011.framework.tool;

import java.awt.event.MouseEvent;
import java.util.List;

import br.ifba.ads.inf011.framework.ButtonTool;
import br.ifba.ads.inf011.framework.Graphic;

public class EraseTool extends ButtonTool{

	public EraseTool(List<Graphic> graphics) {
		super("Apagar", graphics);
	}
	
	public void manipulate() {
		if(this.graphics.size() > 0)
			this.graphics.remove(0);
	}

	
}
