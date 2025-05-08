package br.ifba.ads.inf011;

public class PrinterSpooler {
	
	private Integer impressoes;
	
	private static PrinterSpooler printerSpooler;
	
//	static {
//		PrinterSpooler.printerSpooler = new PrinterSpooler();
//	}
	
	public static PrinterSpooler instance() {
		if(PrinterSpooler.printerSpooler == null)
			PrinterSpooler.printerSpooler = new PrinterSpooler();
		return PrinterSpooler.printerSpooler;
	}
	
	private PrinterSpooler() {
		this.impressoes = 0;
	}
	
	public void print() {
		this.impressoes++;
	}
	
	
	public Integer total() {
		return this.impressoes;
	}
	
	
	
	

}
