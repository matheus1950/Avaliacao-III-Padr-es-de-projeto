package br.edu.ifba.estrutural.external;

import java.awt.Graphics;

public class Text {
    private String content;

    public Text(String content) {
        this.content = content;
    }

    public void write(Graphics g, int x, int y) {
        g.drawString(content, x, y);
    }

    public String getContent() {
        return content;
    }
}

