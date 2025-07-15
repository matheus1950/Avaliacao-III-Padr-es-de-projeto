package br.edu.ifba.comportamental.visitor;

import java.util.HashSet;
import java.util.Set;

public class CountVariablesVisitor implements NodeVisitor {
    private Set<String> declaredVariables = new HashSet<>();

    @Override
    public void visitAssignmentNode(AssignmentNode node) {
    }

    @Override
    public void visitVariableReferenceNode(VariableReferenceNode node) {
    }

    @Override
    public void visitArithmeticExpressionNode(ArithmeticExpressionNode node) {
    }

    @Override
    public void visitVariableDeclarationNode(VariableDeclarationNode node) {
        System.out.println("[CountVariables] Variável declarada: " + node.getVariableName());
        this.declaredVariables.add(node.getVariableName());
    }

    public int getDeclaredVariableCount() {
        return this.declaredVariables.size();
    }

    public Set<String> getDeclaredVariables() {
        return this.declaredVariables;
    }
}