package br.edu.ifba.comportamental.visitor;

import java.util.ArrayList;
import java.util.List;

public class CompilerAST {
	
	
	public void run() {
        List<ASTNode> astNodes = new ArrayList<>();
        astNodes.add(new VariableDeclarationNode("int", "count"));
        astNodes.add(new AssignmentNode("count", "0"));
        astNodes.add(new VariableDeclarationNode("String", "message"));
        astNodes.add(new AssignmentNode("message", "\"Hello, World!\""));
        astNodes.add(new ArithmeticExpressionNode("count + 1")); // Uso de 'count'
        astNodes.add(new VariableReferenceNode("message")); // Uso de 'message'
        astNodes.add(new VariableDeclarationNode("boolean", "is_active")); // Outra declaração
        astNodes.add(new AssignmentNode("is_active", "true"));

        System.out.println("--- Executando Verificação de Tipos ---");
        TypeCheckingVisitor typeChecker = new TypeCheckingVisitor();
        for (ASTNode node : astNodes) {
            node.accept(typeChecker);
        }
        if (typeChecker.getErrors().isEmpty()) {
            System.out.println("Verificação de tipos concluída sem erros.");
        } else {
            System.out.println("Erros de tipo encontrados:");
            for (String error : typeChecker.getErrors()) {
                System.out.println("- " + error);
            }
        }

        System.out.println("\n--- Gerando Código Formatado (Pretty Print) ---");
        PrettyPrintingVisitor prettyPrinter = new PrettyPrintingVisitor();
        for (ASTNode node : astNodes) {
            node.accept(prettyPrinter);
        }
        System.out.println("\nCódigo Formatado:\n" + prettyPrinter.getPrettyPrintedCode());

        System.out.println("\n--- Contando Variáveis Declaradas ---");
        CountVariablesVisitor countVisitor = new CountVariablesVisitor();
        for (ASTNode node : astNodes) {
            node.accept(countVisitor); // O nó "aceita" o visitor contador
        }
        System.out.println("\nTotal de variáveis declaradas (únicas): " + countVisitor.getDeclaredVariableCount());
        System.out.println("Variáveis declaradas: " + countVisitor.getDeclaredVariables());
		
	}
	
	
	public static void main(String[] args) {
		new CompilerAST().run();
	}

}
