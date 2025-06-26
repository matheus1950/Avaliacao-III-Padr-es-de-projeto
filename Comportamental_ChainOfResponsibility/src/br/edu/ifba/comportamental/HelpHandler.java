package br.edu.ifba.comportamental;

public abstract class HelpHandler {
    private HelpHandler successor;

    public HelpHandler(HelpHandler successor) {
        this.successor = successor;
    }

    public void handleHelp(Integer id) {
        if (successor != null)
            successor.handleHelp(id);
        else
        	System.out.println("Ajuda genérica...");
    }


	public HelpHandler getSuccessor() {
        return successor;
    }

    protected void setSuccessor(HelpHandler successor) {
        this.successor = successor;
    }

    protected abstract boolean canHandleHelp(Integer id);
    protected abstract void showHelp();
}