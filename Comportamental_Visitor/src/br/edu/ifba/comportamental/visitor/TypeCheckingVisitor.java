package br.edu.ifba.comportamental.visitor;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckingVisitor implements NodeVisitor {
	
    private List<String> errors = new ArrayList<>();

    @Override
    public void visitAssignmentNode(AssignmentNode node) {
        System.out.println("[TypeCheck] Verificando atribuição: " + node.getVariableName() + " = " + node.getValue());
        if (node.getVariableName().startsWith("int_") && !node.getValue().matches("\\d+")) {
            errors.add("Erro de tipo: Variável " + node.getVariableName() + " deve ser int, mas recebeu " + node.getValue());
        }
    }

    @Override
    public void visitVariableReferenceNode(VariableReferenceNode node) {
        System.out.println("[TypeCheck] Verificando referência de variável: " + node.getVariableName());
    }

    @Override
    public void visitArithmeticExpressionNode(ArithmeticExpressionNode node) {
        System.out.println("[TypeCheck] Verificando expressão aritmética: " + node.getExpression());
    }
    
    @Override
    public void visitVariableDeclarationNode(VariableDeclarationNode node) {
        System.out.println("[TypeCheck] Verificando declaração: " + node.getType() + " " + node.getVariableName());
    }    

    public List<String> getErrors() {
        return errors;
    }
}