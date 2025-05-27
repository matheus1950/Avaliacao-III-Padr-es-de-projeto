package br.edu.ifba.estrutural.proxy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JProxyGUIExample extends JFrame {

    private ImageCanvas canvas;
    private Graphic graphic;
    private String imageFilename = null;
    private JButton selectButton;
    private JButton drawButton;

    public JProxyGUIExample() {
        super("Proxy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());  // Usa BorderLayout
        this.asmCanvas();

        // Painel para os botões na parte inferior
        JPanel buttonPanel = new JPanel(new FlowLayout());
        this.selectButton = this.createSelectButton();
        this.drawButton = this.createDrawButton();
        buttonPanel.add(selectButton);
        buttonPanel.add(drawButton);
        add(buttonPanel, BorderLayout.SOUTH);  // Painel de botões na parte inferior
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    private void asmCanvas() {
        this.canvas = new ImageCanvas();
        this.add(this.canvas, BorderLayout.CENTER); // Canvas no centro
    }
    
    private JButton createSelectButton() {
        JButton selectButton = new JButton("Selecionar Imagem");
        selectButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Imagens", "jpg", "jpeg", "png", "gif");
            fileChooser.setFileFilter(filter);
            int returnVal = fileChooser.showOpenDialog(JProxyGUIExample.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                imageFilename = selectedFile.getAbsolutePath();
                System.out.println("Arquivo selecionado: " + imageFilename);
                graphic = new ImageProxy(imageFilename); //Cria o Proxy
                canvas.setGraphic(graphic); //Define o Proxy no Canvas
                canvas.repaint(); // Redesenha o Canvas
            }
        });
        return selectButton;
    }
    
    private JButton createDrawButton() {
        JButton drawButton = new JButton("Desenhar Imagem");
        drawButton.addActionListener(e -> {
            if (imageFilename != null) {
            	graphic.forceDrawing();
                canvas.setGraphic(graphic);
                canvas.repaint(); 
            } else {
                JOptionPane.showMessageDialog(JProxyGUIExample.this, "Selecione uma imagem primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        return drawButton;
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JProxyGUIExample());
    }
}


