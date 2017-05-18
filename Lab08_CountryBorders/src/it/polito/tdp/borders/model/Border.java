package it.polito.tdp.borders.model;

public class Border {
	
	private int cc1;
	private int cc2;
	private int year;
	private int tipo;
	
	public Border(int cc1, int cc2, int year, int tipo) {
		super();
		this.cc1 = cc1;
		this.cc2 = cc2;
		this.year = year;
		this.tipo = tipo;
	}

	public int getCc1() {
		return cc1;
	}

	public int getCc2() {
		return cc2;
	}

	public int getYear() {
		return year;
	}

	public int getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return cc1 + " " + cc2 + " " + year + " " + tipo;
	}
	
	
	
}
