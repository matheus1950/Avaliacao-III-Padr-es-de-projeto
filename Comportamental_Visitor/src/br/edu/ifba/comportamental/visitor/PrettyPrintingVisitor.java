package br.edu.ifba.comportamental.visitor;

public class PrettyPrintingVisitor implements NodeVisitor {
    private StringBuilder output = new StringBuilder();
    private int indentLevel = 0;

    private void indent() {
        for (int i = 0; i < indentLevel; i++) {
            this.output.append("    "); // 4 espaços por nível de indentação
        }
    }

    @Override
    public void visitAssignmentNode(AssignmentNode node) {
        indent();
        this.output.append(node.getVariableName()).append(" = ").append(node.getValue()).append(";\n");
    }

    @Override
    public void visitVariableReferenceNode(VariableReferenceNode node) {
    	this.output.append(node.getVariableName()); // Referências podem ser parte de expressões
    }

    @Override
    public void visitArithmeticExpressionNode(ArithmeticExpressionNode node) {
    	this.output.append("(").append(node.getExpression()).append(")"); // Adiciona parênteses para clareza
    }
    
    @Override
    public void visitVariableDeclarationNode(VariableDeclarationNode node) {
        indent();
        this.output.append(node.getType()).append(" ").append(node.getVariableName()).append(";\n");
    }    

    public String getPrettyPrintedCode() {
        return this.output.toString();
    }
}