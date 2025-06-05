package br.edu.ifba.estrutural.bridge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class JDrawingBridgeGUI extends JFrame {

    private JPanel drawingPanel;
    private JRadioButton solidButton, dashedButton, dottedButton;
    private DrawShape drawShape = new DrawShape(new SolidPen());

    public JDrawingBridgeGUI() {
        setTitle("Drawing Editor - House and Sun");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Drawing Panel
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawHouseAndSun(g); // Draw the house and sun
            }
        };
        drawingPanel.setBackground(Color.WHITE);
        add(drawingPanel, BorderLayout.CENTER);

        // Control Panel for Pen Selection
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        solidButton = new JRadioButton("Solid", true); // Default selected
        dashedButton = new JRadioButton("Dashed");
        dottedButton = new JRadioButton("Dotted");

        ButtonGroup penGroup = new ButtonGroup();
        penGroup.add(solidButton);
        penGroup.add(dashedButton);
        penGroup.add(dottedButton);

        solidButton.addActionListener(e -> {
            this.drawShape.setPen(new SolidPen());
            drawingPanel.repaint(); // Redraw with the new pen
        });
        dashedButton.addActionListener(e -> {
        	this.drawShape.setPen(new DashedPen());
            drawingPanel.repaint(); // Redraw with the new pen
        });
        dottedButton.addActionListener(e -> {
        	this.drawShape.setPen(new DottedPen());
            drawingPanel.repaint(); // Redraw with the new pen
        });

        controlPanel.add(new JLabel("Estilo da Caneta:"));
        controlPanel.add(solidButton);
        controlPanel.add(dashedButton);
        controlPanel.add(dottedButton);

        add(controlPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void drawHouseAndSun(Graphics g) {
    	
        // Casa
        int baseHouseX = 250;
        int baseHouseY = 250;
        int heightWall = 100;
        int roofSize = 100;
        int doorWidth = 40;
        int doorHeight = 50;


        // Sol (Circle)
        this.drawShape.innerCircle(g, 80, 80, 40);

        //Casa
        this.drawShape.line(g, baseHouseX - 50, baseHouseY, 100, 0); 
        this.drawShape.line(g, baseHouseX - 50, baseHouseY, heightWall, Math.PI/2 * 3); 
        this.drawShape.line(g, baseHouseX + 50, baseHouseY, heightWall, Math.PI/2 * 3);
        this.drawShape.line(g, baseHouseX - 70, baseHouseY - heightWall + 20, roofSize, -Math.PI/4); 
        this.drawShape.line(g, baseHouseX, baseHouseY - heightWall - 50, roofSize, Math.PI/4 ); 

        int doorX = baseHouseX - doorWidth / 2;
        this.drawShape.line(g, doorX, baseHouseY, doorHeight, Math.PI/2 * 3 ); //Left Door, Left = 3/2 PI or - PI/2
        this.drawShape.line(g, doorX + doorWidth, baseHouseY, doorHeight, Math.PI/2 * 3); //Right Door, Left = 3/2 PI or - PI/2
        this.drawShape.line(g, doorX, baseHouseY - doorHeight, doorWidth, 0); // Top Door
        
        //Maçaneta
        this.drawShape.circle(g, doorX + 20, baseHouseY - doorHeight / 2, 5);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JDrawingBridgeGUI::new);
    }
}