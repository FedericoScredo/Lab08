package it.polito.tdp.borders.model;

public class CountryPair {
	
	private Country c1,c2;
	private int year,type;
	
	public CountryPair(Country c1, Country c2, int year, int type) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.year = year;
		this.type = type;
	}

	public Country getC1() {
		return c1;
	}

	public Country getC2() {
		return c2;
	}

	public int getYear() {
		return year;
	}

	public int getType() {
		return type;
	}
	
	

}
