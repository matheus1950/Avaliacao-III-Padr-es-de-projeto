package br.edu.ifba.estrutural.facade;

import java.util.List;

public class Compiler {
	
   private Scanner scanner;
   private Parser parser;
   private ProgramNode programNode;
   private ByteCodeStream bytecodeStream;
	
	
   public Compiler() {
	   this.init();
   }
   
	private void init() {
		this.scanner = new SketchScanner();
	    this.parser = new BasicParser();
	    this.programNode = ProgramNodeBuilder.builder()
	    									 .reset()
	    									 .optimizer()
	    									 .semanticCheckedNode()
	    									 .typeCheckedNode()
	    									 .build();
	    this.bytecodeStream = new ArduinoByteCodeStream();

	}
	
	
    public void compile(String sourceCode) {
        Client.LOGGER.info("Compiler: Iniciando o processo de compilação.");
        String[] tokens = this.scanner.run(sourceCode);
        AST ast = this.parser.run(tokens);
        AST optimizedAst = this.programNode.run(ast);
        List<Byte> bytecode = this.bytecodeStream.generate(optimizedAst);
        Client.LOGGER.info("Codigo gerado: " + bytecode.size() + " bytes");
        Client.LOGGER.info("Compiler: Compilação concluída.");
    }	

}
