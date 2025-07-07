package br.edu.ifba.comportamental.tm;

public class DrawingApplication extends Application {
    @Override
    protected boolean canOpenDocument(String name) {
        return name.endsWith(".draw"); // Apenas arquivos .draw são válidos para DrawingApplication
    }

    @Override
    protected Document doCreateDocument(String name) {
        return new DrawingDocument(name);
    }

    @Override
    protected void aboutToOpenDocument(String name) {
        super.aboutToOpenDocument(name);
    }
}