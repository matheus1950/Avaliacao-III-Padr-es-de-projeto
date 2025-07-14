package br.edu.ifba.comportamental.memento.originator;

import java.time.LocalDateTime;
import java.util.Objects;

public class DocumentoMemento {
    private final String content;
    private final LocalDateTime timestamp;
    private final int cursorPosition; 

    public DocumentoMemento(String content, int cursorPosition) {
        this.content = Objects.requireNonNull(content, "Content cannot be null");
        this.timestamp = LocalDateTime.now();
        this.cursorPosition = cursorPosition;
    }

    protected String getContent() {
        return content;
    }

    protected LocalDateTime getTimestamp() {
        return timestamp;
    }

    protected int getCursorPosition() {
        return cursorPosition;
    }

    @Override
    public String toString() {
        return "DocumentState [Content Hash: " + content.hashCode() + ", Timestamp: " + timestamp + ", Cursor: " + cursorPosition + "]";
    }
}