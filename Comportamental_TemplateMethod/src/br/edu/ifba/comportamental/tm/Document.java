package br.edu.ifba.comportamental.tm;

public abstract class Document {
    protected String name;

    public Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Operação Primitiva (Primitive Operation)
     * Define como o documento é lido a partir de um formato externo.
     * Esta é uma operação abstrata que deve ser implementada por subclasses concretas de Document.
     * O Template Method (openDocument) chamará esta operação. [6]
     */
    public abstract void doRead();

    public void display() {
        System.out.println("    Exibindo documento: " + name);
    }
}