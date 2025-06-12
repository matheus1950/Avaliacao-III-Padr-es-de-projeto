package br.edu.ifba.comportamental;

public class ArrayCompositor implements Compositor {
	 private final int itemsPerLine;
	
	 public ArrayCompositor(int itemsPerLine) {
	     this.itemsPerLine = itemsPerLine;
	 }

	 @Override
	 public String compose(String text) {
	     System.out.printf("--- Formatando com ArrayCompositor (%d palavras por linha) ---\n", this.itemsPerLine);
	     String[] words = text.split("\\s+");
	     StringBuilder result = new StringBuilder();
	     for (int i = 0; i < words.length; i++) {
	         result.append(words[i]).append(" ");
	         if ((i + 1) % itemsPerLine == 0) {
	             result.append("\n");
	         }
	     }
	     return result.toString().trim();
	 }
}