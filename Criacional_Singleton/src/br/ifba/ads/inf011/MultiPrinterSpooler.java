package br.ifba.ads.inf011;

import java.util.ArrayList;
import java.util.List;

public class MultiPrinterSpooler {
	
	private Integer impressoes;
	
	private static List<MultiPrinterSpooler> printersSpooler;
	private static Integer printerSpoolerNdx;
	
	static {
		MultiPrinterSpooler.printersSpooler = new ArrayList<MultiPrinterSpooler>();
		MultiPrinterSpooler.printersSpooler.add(new MultiPrinterSpooler());
		MultiPrinterSpooler.printersSpooler.add(new MultiPrinterSpooler());
		MultiPrinterSpooler.printerSpoolerNdx = 0;
	}
	
	public static MultiPrinterSpooler instance() {
		Integer indice = MultiPrinterSpooler.printerSpoolerNdx %= 2;
		MultiPrinterSpooler.printerSpoolerNdx++;
		return MultiPrinterSpooler.printersSpooler.get(indice);
		
	}
	
	private MultiPrinterSpooler() {
		this.impressoes = 0;
	}
	
	public void print() {
		this.impressoes++;
	}
	
	
	public Integer total() {
		return this.impressoes;
	}
	
	
	
	

}
