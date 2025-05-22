package br.edu.ifba.estrutural.extended;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.edu.ifba.estrutural.adapter.TextClasseAdapter;
import br.edu.ifba.estrutural.adapter.TextObjectAdapter;
import br.edu.ifba.estrutural.external.Text;
import br.edu.ifba.estrutural.framework.JAdapterGUIExample;


public class JExtendedAdapterGUIExample extends JAdapterGUIExample{
	
  
    public JPanel asmPainelLateral() {
    	JPanel buttonPanel =   super.asmPainelLateral();
        this.addShapeButton(buttonPanel, new TextObjectAdapter(new Text("ADAPTER DE OBJETO")), "Adapter de Objeto");
        this.addShapeButton(buttonPanel, new TextClasseAdapter("ADAPTER DE CLASSE"), "Adapter de Classe");
        return buttonPanel;
	}
	
    public int getQtdeButoes(){
    	return 4;
    }
	
    
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JExtendedAdapterGUIExample();
            }
        });
    }	
	

}
