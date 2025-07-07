package br.edu.ifba.comportamental.tm;

public class DrawingDocument extends Document {
    public DrawingDocument(String name) {
        super(name);
    }

    @Override
    public void doRead() {
        System.out.println("    Operação Primitiva: Lendo dados de desenho para o documento '" + name + "'...");
    }
}