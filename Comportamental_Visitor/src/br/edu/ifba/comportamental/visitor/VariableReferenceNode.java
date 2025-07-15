package br.edu.ifba.comportamental.visitor;

public class VariableReferenceNode implements ASTNode {
    private String variableName;

    public VariableReferenceNode(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitVariableReferenceNode(this);
    }
}