package br.edu.ifba.comportamental.visitor;

public  class AssignmentNode implements ASTNode {
	
    private String variableName;
    private String value;

    public AssignmentNode(String variableName, String value) {
        this.variableName = variableName;
        this.value = value;
    }

    public String getVariableName() {
        return variableName;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitAssignmentNode(this);
    }
}