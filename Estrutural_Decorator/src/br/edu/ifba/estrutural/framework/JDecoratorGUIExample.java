package br.edu.ifba.estrutural.framework;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class JDecoratorGUIExample extends JFrame {

    private JPanel drawingPanel;
    private List<Shape> shapes;
    private Shape selectedShape = null;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton addDottedCircleButton;
    private JButton addDottedSquareButton;

    public JDecoratorGUIExample() {
        this.shapes = new ArrayList<>();
        this.asmWindowApp();
        this.asmPainelCentral();
        this.asmPainelLateral();
        this.asmPainelSuperior(); // Nova barra superior
        this.setVisible(true);
    }

    private void asmWindowApp() {
        this.setTitle("Decorator Pattern - Exemplo");
        this.setSize(600, 500); // Aumentar altura para a barra superior
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void asmPainelCentral() {
        this.drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Shape shape : shapes) {
                    shape.draw(g);
                }
            }
        };
        this.drawingPanel.setBackground(Color.WHITE);
        this.drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedShape != null) {
                    Shape newShape = selectedShape.clone();
                    newShape.setX(e.getX());
                    newShape.setY(e.getY());
                    shapes.add(newShape);
                    drawingPanel.repaint();
                }
            }
        });
        this.add(drawingPanel, BorderLayout.CENTER);
    }

    private void asmPainelSuperior() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        addDottedCircleButton = new JButton("Adicionar Círculo Pontilhado");
        addDottedCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyDottedCircleDecorator();
            }
        });
        topPanel.add(addDottedCircleButton);

        addDottedSquareButton = new JButton("Adicionar Quadrado Pontilhado");
        addDottedSquareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyDottedSquareDecorator();
            }
        });
        topPanel.add(addDottedSquareButton);

        this.add(topPanel, BorderLayout.NORTH);
    }

    private void applyDottedCircleDecorator() {
        List<Shape> newShapes = new ArrayList<>();
        for (Shape shape : shapes) 
            newShapes.add(new DottedCircleDecorator(shape));
        shapes = newShapes;  // Substitui a lista antiga
        drawingPanel.repaint();
    }
    
    private void applyDottedSquareDecorator() {
        List<Shape> newShapes = new ArrayList<>();
        for (Shape shape : shapes) 
            newShapes.add(new DottedSquareDecorator(shape));
        shapes = newShapes;  // Substitui a lista antiga
        drawingPanel.repaint();
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
        buttonPanel.setLayout(new GridLayout(2, 1));

        // Adicionar os botões
        this.addShapeButton(buttonPanel, new RectShape(), "[]");
        this.addShapeButton(buttonPanel, new CircleShape(), "o");

        this.add(buttonPanel, BorderLayout.WEST);
        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JDecoratorGUIExample();
            }
        });
    }
}