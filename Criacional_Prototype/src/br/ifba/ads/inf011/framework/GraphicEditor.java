package br.ifba.ads.inf011.framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GraphicEditor extends JFrame implements MouseListener{

    private JPanel canvas;
    private JPanel sidebar;
    protected List<Graphic> graphics = new ArrayList<Graphic>();
    protected ButtonTool ferramentaSelecionada = null; // Valor padrão
    protected Color corAtual = Color.BLACK;
    

    public GraphicEditor() {
        this.setTitle("Framework Editor Grafico");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        // Criar o canvas
        this.asmCanvas();
        this.asmSideBar();
        // Adicionar os painéis ao JFrame
        add(canvas, BorderLayout.CENTER);
        add(sidebar, BorderLayout.WEST);
        setVisible(true);
    }
    
    
    @SuppressWarnings("serial")
	public void asmCanvas() {
        this.canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                for (Graphic graph : graphics)
                	graph.draw(g2d);
            }
        };
        this.canvas.setBackground(Color.WHITE);
        this.canvas.addMouseListener(this);
    }
    
    public abstract List<JButton> addSideButtons();    
    
    public void asmSideBar() {
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS)); // Layout vertical
        for(JButton btn : this.addSideButtons())
        	sidebar.add(btn);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		this.ferramentaSelecionada.setColor(corAtual);
		this.ferramentaSelecionada.mouseClicked(e);// TODO Auto-generated method stub
		this.canvas.updateUI();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }	
    
};    
