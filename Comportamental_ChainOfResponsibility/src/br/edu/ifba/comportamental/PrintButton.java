package br.edu.ifba.comportamental;

public class PrintButton extends HelpHandler {
	
    private static final int HELP_TOPIC = 1; 

    public PrintButton(HelpHandler successor) {
        super(successor);
    }

    @Override
    public void handleHelp(Integer id) {
        if (this.canHandleHelp(id)) {
            this.showHelp();
        } else {
            super.handleHelp(id); 
        }
    }
    
    @Override
    protected void showHelp() {
    	System.out.println("Ajuda específica para o botão Print.");  	
    };      

    @Override
    public boolean canHandleHelp(Integer id) {
        return id == PrintButton.HELP_TOPIC;
    }
}

