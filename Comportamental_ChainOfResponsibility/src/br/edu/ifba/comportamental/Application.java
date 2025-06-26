package br.edu.ifba.comportamental;

public class Application extends HelpHandler {
    private static final int HELP_TOPIC = 3; 

    public Application(HelpHandler successor) {
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
        System.out.println("Ajuda específica da aplicação.");	
    };      

    @Override
    public boolean canHandleHelp(Integer id) {
        return id == Application.HELP_TOPIC;
    }
}