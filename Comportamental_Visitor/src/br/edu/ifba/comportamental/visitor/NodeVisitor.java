package br.edu.ifba.comportamental.visitor;

public interface NodeVisitor {
    public void visitAssignmentNode(AssignmentNode node);
    public void visitVariableReferenceNode(VariableReferenceNode node);
    public void visitArithmeticExpressionNode(ArithmeticExpressionNode node);
    public void visitVariableDeclarationNode(VariableDeclarationNode node);
}