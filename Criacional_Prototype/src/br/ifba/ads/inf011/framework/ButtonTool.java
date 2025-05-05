package br.ifba.ads.inf011.framework;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;

import br.ifba.ads.inf011.framework.tool.Tool;

@SuppressWarnings("serial")
public abstract class ButtonTool extends JButton implements Tool, MouseListener{
	
	protected List<Graphic> graphics;
	protected int xInicial, yInicial, xFinal, yFinal;	
	protected Color color;
	
	
	public ButtonTool(String caption, List<Graphic> graphics) {
		super(caption);
		this.graphics = graphics;
	}
	
	
	public void setColor(Color color){
		this.color = color;
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		xInicial = e.getX();
		yInicial = e.getY();
		this.manipulate();
	}

	
	

}
