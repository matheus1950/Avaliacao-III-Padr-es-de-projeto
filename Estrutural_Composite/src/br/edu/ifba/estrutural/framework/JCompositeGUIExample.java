package br.edu.ifba.estrutural.framework;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class JCompositeGUIExample extends JFrame {

    private JPanel drawingPanel;
    private List<Shape> shapes;
    private AbstractShape selectedShape = null;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton groupButton;
    private List<Shape> selectedForGroup;
    private Shape draggedShape = null;
    private int dragOffsetX;
    private int dragOffsetY;
    private JButton deselectButton;  


    public JCompositeGUIExample() {
        this.selectedForGroup = new ArrayList<>();
        this.shapes = new ArrayList<>();
        this.asmWindowApp();
        this.asmPainelCentral();
        this.asmPainelLateral();
        this.asmPainelSuperior(); // Nova barra superior
        this.setVisible(true);
    }

    private void asmWindowApp() {
        this.setTitle("Composite Pattern - Exemplo");
        this.setSize(600, 500);
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
                // Desenha uma borda ao redor das formas selecionadas para o grupo
                g.setColor(Color.BLUE);
                for (Shape shape : selectedForGroup) {
                    g.drawRect(shape.getX() - shape.getXSize() / 2 - 2,
                            shape.getY() - shape.getYSize() / 2 - 2,
                            shape.getXSize() + 4, shape.getYSize() + 4);
                }
            }
        };
        this.drawingPanel.setBackground(Color.WHITE);
        // Adiciona os listeners de mouse para drag and drop
        this.drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                draggedShape = findShapeAt(e.getX(), e.getY());
                if (draggedShape != null) {
                    dragOffsetX = e.getX() - draggedShape.getX();
                    dragOffsetY = e.getY() - draggedShape.getY();
                } else if (selectedShape == null) {
                    // Se nenhuma forma está selecionada, permite selecionar para agrupar
                    Shape clickedShape = findShapeAt(e.getX(), e.getY());
                    if (clickedShape != null) {
                        if (selectedForGroup.contains(clickedShape)) {
                            selectedForGroup.remove(clickedShape); // Desseleciona
                        } else {
                            selectedForGroup.add(clickedShape); // Seleciona
                        }
                        groupButton.setEnabled(selectedForGroup.size() >= 2);
                        drawingPanel.repaint();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                draggedShape = null; // Libera a forma arrastada
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedShape != null) {
                    AbstractShape newShape = (AbstractShape) selectedShape.clone();
                    newShape.move(e.getX(), e.getY());
                    shapes.add(newShape);
                    drawingPanel.repaint();
                } else {
                    // Se nenhuma forma estiver selecionada, permite selecionar para agrupar
                    Shape clickedShape = findShapeAt(e.getX(), e.getY());
                    if (clickedShape != null) {
                        if (selectedForGroup.contains(clickedShape)) {
                            selectedForGroup.remove(clickedShape); // Desseleciona
                        } else {
                            selectedForGroup.add(clickedShape); // Seleciona
                        }
                        groupButton.setEnabled(selectedForGroup.size() >= 2);
                        drawingPanel.repaint();
                    }
                }
            }
        });

        this.drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (draggedShape != null) {
                    int newX = e.getX() - dragOffsetX;
                    int newY = e.getY() - dragOffsetY;
                    draggedShape.move(newX, newY); // Define a nova posição
                    drawingPanel.repaint();
                }
            }
        });

        this.add(drawingPanel, BorderLayout.CENTER);
    }

    private Shape findShapeAt(int x, int y) {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            Shape shape = shapes.get(i);
            Shape found = shape.findShapeAt(x, y);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    private void asmPainelSuperior() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        groupButton = new JButton("Agrupar");
        groupButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    groupSelectedShapes(); // Chama o método de agrupamento existente
                }
            });
        groupButton.setEnabled(false); // Desabilitado inicialmente
        topPanel.add(groupButton);

        this.add(topPanel, BorderLayout.NORTH);
    }

    
    private void deSelectShapes() {
    	if (this.selectedForGroup.size() == 0)
    		return;
    	this.selectedForGroup.clear();
    	this.drawingPanel.repaint();
    	
    }

    private void groupSelectedShapes() {
        if (selectedForGroup.size() > 1) {
            Picture picture = new Picture();

            // Adiciona os shapes selecionados à Picture e remove da lista principal
            List<Shape> shapesToRemove = new ArrayList<>(selectedForGroup); // Crie uma cópia para evitar ConcurrentModificationException
            for (Shape shape : shapesToRemove) {
                picture.add(shape);
                shapes.remove(shape);
            }

            shapes.add(picture); // Adiciona a Picture à lista principal
            selectedForGroup.clear(); // Limpa a seleção

            groupButton.setEnabled(false); // Desabilita o botão de agrupar
            drawingPanel.repaint(); // Redesenha o painel
        } else {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos duas formas para agrupar.");
        }
    }



    public void addShapeButton(JPanel buttonPanel, AbstractShape shapePrototype, String buttonText) {
        JToggleButton button = new JToggleButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.isSelected()) {
                    selectedShape = shapePrototype;
                    groupButton.setEnabled(false);
                    deSelectShapes();
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
        buttonPanel.setLayout(new GridLayout(6, 1));

        // Adicionar os botões de forma
        this.addShapeButton(buttonPanel, new RectShape(), "[]");
        this.addShapeButton(buttonPanel, new CircleShape(), "o");
        this.addShapeButton(buttonPanel, new LineShape(), "---");

        // Adicionar botão para desselecionar
        deselectButton = new JButton("Desselecionar");
        deselectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape = null; // Desseleciona a forma atual
                buttonGroup.clearSelection(); // Desmarca qualquer botão selecionado
                System.out.println("Ferramenta Desselecionada");
            }
        });
        buttonPanel.add(deselectButton);

        this.add(buttonPanel, BorderLayout.WEST);
        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JCompositeGUIExample();
            }
        });
    }
}