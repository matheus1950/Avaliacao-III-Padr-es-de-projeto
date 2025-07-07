package br.edu.ifba.comportamental.tm;

public class SpreadsheetApplication extends Application {
    @Override
    protected boolean canOpenDocument(String name) {
        return name.endsWith(".xls") || name.endsWith(".csv"); // Apenas .xls ou .csv para SpreadsheetApplication
    }

    @Override
    protected Document doCreateDocument(String name) {
        return new SpreadsheetDocument(name);
    }
}