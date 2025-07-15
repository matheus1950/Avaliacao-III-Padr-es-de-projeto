package br.edu.ifba.comportamental.visitor;

public class ArithmeticExpressionNode implements ASTNode {
	
    private String expression; 

    public ArithmeticExpressionNode(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitArithmeticExpressionNode(this); 
    }
}