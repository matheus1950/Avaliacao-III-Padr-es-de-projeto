package br.edu.ifba.comportamental.visitor;

public class VariableDeclarationNode implements ASTNode {
    private String type;
    private String variableName;

    public VariableDeclarationNode(String type, String variableName) {
        this.type = type;
        this.variableName = variableName;
    }

    public String getType() {
        return type;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitVariableDeclarationNode(this); // Novo método para este nó
    }
}