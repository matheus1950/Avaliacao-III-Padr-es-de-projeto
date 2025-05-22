package br.edu.ifba.estrutural.framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class JAdapterGUIExample extends JFrame{
	
    private JPanel drawingPanel;
    private List<Shape> shapes;
    
    private Shape selectedShape = null; // Forma selecionada para desenhar
    private ButtonGroup buttonGroup = new ButtonGroup(); // Garante que só 1 botão esteja on
    
    public JAdapterGUIExample() {
    	this.shapes = new ArrayList<Shape>();
    	this.asmWindowApp();
    	this.asmPainelCentral();
    	this.asmPainelLateral();
    	this.setVisible(true);
    }
    
    public int getQtdeButoes(){
    	return 2;
    }

    
    private void asmWindowApp() {
        this.setTitle("Adapter Pattern - Exemplo");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  	
    }
    
    
    private void asmPainelCentral() {
        this.drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape shape : shapes) {
                    shape.draw(g, shape.getX(), shape.getY());
                }
            }
        };
        this.drawingPanel.setBackground(Color.WHITE);
        this.drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedShape != null) {
                    Shape newShape = selectedShape.clone();  // Clona o protótipo
                    newShape.setX(e.getX());
                    newShape.setY(e.getY());
                    shapes.add(newShape);
                    drawingPanel.repaint();
                }
            }
        });	
        this.add(drawingPanel, BorderLayout.CENTER);
    }
    
    
    public void addShapeButton(JPanel buttonPanel, Shape shapePrototype, String buttonText) {
        JToggleButton button = new JToggleButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.isSelected()) {
                    selectedShape = shapePrototype;
                    System.out.println(shapePrototype.getClass().getSimpleName() + " selecionado");
                } else {
                    selectedShape = null;
                    System.out.println("Nenhuma forma selecionada");
                }
            }
        });
        buttonGroup.add(button);
        buttonPanel.add(button);
    }    
    
    public JPanel asmPainelLateral() {
    	
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(this.getQtdeButoes(), 1));

        // Adicionar os botões
        this.addShapeButton(buttonPanel, new RectShape(), "[]");
        this.addShapeButton(buttonPanel, new CircleShape(), "o");

        this.add(buttonPanel, BorderLayout.WEST);
        return buttonPanel;
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JAdapterGUIExample();
            }
        });
    }
}	


