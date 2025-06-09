package br.edu.ifba.estrutural.facade;

public class ProgramNodeBuilder {
	
	
	public static ProgramNodeBuilder builder() {
		return new ProgramNodeBuilder();
	}
	
	public ProgramNodeBuilder reset() {
		return this;
	}
	
	public ProgramNodeBuilder typeCheckedNode() {
		return this;
	}
	
	public ProgramNodeBuilder optimizer() {
		return this;
	}
	
	public ProgramNodeBuilder semanticCheckedNode() {
		return this;
	}
	

	public ProgramNode build() {
		return new SafetyProgramNode();
	}
	

}
