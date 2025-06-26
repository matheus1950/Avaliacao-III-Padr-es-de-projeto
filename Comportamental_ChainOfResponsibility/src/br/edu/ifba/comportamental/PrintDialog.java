package br.edu.ifba.comportamental;

public class PrintDialog extends HelpHandler {
    private static final int HELP_TOPIC = 2; 

    public PrintDialog(HelpHandler successor) {
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
    	System.out.println("Ajuda específica para a caixa de diálogo Print.");    	
    };    

    @Override
    public boolean canHandleHelp(Integer id) {
        return id == PrintDialog.HELP_TOPIC;
    }
}