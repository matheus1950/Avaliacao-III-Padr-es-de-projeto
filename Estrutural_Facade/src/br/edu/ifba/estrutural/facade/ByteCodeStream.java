package br.edu.ifba.estrutural.facade;

import java.util.List;

public interface ByteCodeStream {
    public List<Byte> generate(AST optimizedAst);

}