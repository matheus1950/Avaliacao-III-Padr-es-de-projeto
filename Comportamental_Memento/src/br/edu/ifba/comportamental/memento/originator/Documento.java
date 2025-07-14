package br.edu.ifba.comportamental.memento.originator;

import java.time.LocalDateTime;

public class Documento {
    private String content;
    private int cursorPosition;
    private LocalDateTime lastModified;

    public Documento() {
        this.content = "";
        this.cursorPosition = 0;
        this.lastModified = LocalDateTime.now();
    }

    public void addText(String text) {
        this.content += text;
        this.cursorPosition += text.length();
        this.lastModified = LocalDateTime.now();
    }

    public void deleteLastChar() {
        if (!this.content.isEmpty()) {
            this.content = this.content.substring(0, this.content.length() - 1);
            this.cursorPosition = Math.max(0, this.cursorPosition - 1);
            this.lastModified = LocalDateTime.now();
        }
    }

    public void setCursorPosition(int position) {
        if (position >= 0 && position <= content.length()) {
            this.cursorPosition = position;
        }
    }
    
    public String getContent(){
    	return this.content;
    }


    public DocumentoMemento createMemento() {
        return new DocumentoMemento(this.content, this.cursorPosition);
    }

    public void restoreMemento(DocumentoMemento memento) {
        if (memento != null) {
            this.content = memento.getContent();
            this.cursorPosition = memento.getCursorPosition();
            this.lastModified = memento.getTimestamp();
        }    
    }

    public void displayCurrentState() {
        System.out.println("--- Estado Atual do Documento ---");
        System.out.println("Conteúdo: '" + content + "'");
        System.out.println("Posição do Cursor: " + cursorPosition);
        System.out.println("Última Modificação: " + lastModified);
        System.out.println("---------------------------------");
    }
}