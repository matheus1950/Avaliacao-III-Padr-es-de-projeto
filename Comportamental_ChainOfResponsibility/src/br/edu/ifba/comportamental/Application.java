package br.edu.ifba.comportamental;

public class Application extends HelpHandler {
    private static final int HELP_TOPIC = 3; 

    public Application(HelpHandler successor) {
        super(successor);
    }

    @Override
    public void handleHelp(Integer id) {
        if (canHandleHelp(id)) {
            System.out.println("Ajuda específica da aplicação.");
        } else {
            super.handleHelp(id); 
        }
    }

    @Override
    public boolean canHandleHelp(Integer id) {
        return id == Application.HELP_TOPIC;
    }
}