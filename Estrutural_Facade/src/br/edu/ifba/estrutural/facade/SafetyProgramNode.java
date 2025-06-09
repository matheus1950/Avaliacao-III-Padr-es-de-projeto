package br.edu.ifba.estrutural.facade;

public class SafetyProgramNode implements ProgramNode {

	@Override
	public AST run(AST ast) {
		Client.LOGGER.info("Safety Program Node: Executando verificação de tipo e de semantica nos nós...");
		AST safetyAST = ast;
		Client.LOGGER.info("Safety Program Node: AST verificada...");
		return safetyAST;
	}

}
