package br.ifba.ads.inf011;

public class PrinterSpooler {
	
	private Integer impressoes;
	
	private static PrinterSpooler printerSpooler;
	
	public static void register(PrinterSpooler printerSpooler) {
		PrinterSpooler.printerSpooler = printerSpooler;
	}
	
	public static PrinterSpooler instance() {
		if(PrinterSpooler.printerSpooler == null)
			PrinterSpooler.printerSpooler = new PrinterSpooler();
		return PrinterSpooler.printerSpooler;
	}
	
	protected PrinterSpooler() {
		this.impressoes = 0;
	}
	
	public void print() {
		this.impressoes++;
	}
	
	
	public Integer total() {
		return this.impressoes;
	}
	
	
	
	

}
