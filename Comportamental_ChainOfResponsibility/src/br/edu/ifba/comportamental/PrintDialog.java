package br.edu.ifba.comportamental;

public class PrintDialog extends HelpHandler {
    private static final int HELP_TOPIC = 2; 

    public PrintDialog(HelpHandler successor) {
        super(successor);
    }

    @Override
    public void handleHelp(Integer id) {
        if (canHandleHelp(id)) {
            System.out.println("Ajuda específica para a caixa de diálogo Print.");
        } else {
            super.handleHelp(id); 
        }
    }

    @Override
    public boolean canHandleHelp(Integer id) {
        return id == PrintDialog.HELP_TOPIC;
    }
}