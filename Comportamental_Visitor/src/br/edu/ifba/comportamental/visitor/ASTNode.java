package br.edu.ifba.comportamental.visitor;

public interface ASTNode {
    public void accept(NodeVisitor visitor);
}
