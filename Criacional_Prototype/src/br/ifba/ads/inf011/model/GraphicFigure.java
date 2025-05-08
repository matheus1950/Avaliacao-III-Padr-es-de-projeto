package br.ifba.ads.inf011.model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.SwingUtilities;

import br.ifba.ads.inf011.framework.ButtonTool;
import br.ifba.ads.inf011.framework.GraphicEditor;
import br.ifba.ads.inf011.framework.tool.EraseTool;

public class GraphicFigure extends GraphicEditor{
	
 
    public List<JButton> addSideButtons() {
    	
    	List<JButton> buttons = new ArrayList<JButton>();
    	
    	ButtonTool btn = new EraseTool(this.graphics);
    	btn.addActionListener(e -> ferramentaSelecionada = btn);
    	buttons.add(btn);
    	
    	ButtonTool btn2 = new GraphicTool("Circulo", this.graphics, new GraphicOval());
    	btn2.addActionListener(e -> ferramentaSelecionada = btn2);
    	buttons.add(btn2);
    	
    	ButtonTool btn3 = new GraphicTool("OI", this.graphics, new GraphicHello());
    	btn3.addActionListener(e -> ferramentaSelecionada = btn3);
    	buttons.add(btn3);
    	
    	ButtonTool btn5 = new GraphicTool("Retangulo", this.graphics, new GraphicRetangulo());
    	btn5.addActionListener(e -> ferramentaSelecionada = btn5);
    	buttons.add(btn5);
    	    	
    	
    	
    	JButton btn4 = new JButton("Cor");
        btn4.addActionListener(e -> {
            Color novaCor = JColorChooser.showDialog(GraphicFigure.this, "Escolha uma cor", corAtual);
            				   if (novaCor != null) {
            					   	corAtual = novaCor;
            				   }
        });
    	buttons.add(btn4);

    	return buttons;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphicFigure::new);
    }        
        
	

}
