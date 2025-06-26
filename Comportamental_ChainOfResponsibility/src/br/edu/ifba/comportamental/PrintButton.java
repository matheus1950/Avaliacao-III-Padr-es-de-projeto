package br.edu.ifba.comportamental;

public class PrintButton extends HelpHandler {
	
    private static final int HELP_TOPIC = 1; 

    public PrintButton(HelpHandler successor) {
        super(successor);
    }

    @Override
    public void handleHelp(Integer id) {
        if (canHandleHelp(id)) {
            System.out.println("Ajuda específica para o botão Print.");
        } else {
            super.handleHelp(id); 
        }
    }

    @Override
    public boolean canHandleHelp(Integer id) {
        return id == PrintButton.HELP_TOPIC;
    }
}

