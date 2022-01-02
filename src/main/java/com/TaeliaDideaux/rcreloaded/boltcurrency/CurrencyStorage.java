package com.TaeliaDideaux.rcreloaded.boltcurrency;

public class CurrencyStorage implements ICurrencyCapability {
	
	private int bolts = 0;
	
	@Override public int getBolts() { return bolts; }
	@Override public void setBolts(int value) { this.bolts = clamp(value); }
	
	private int clamp(int value) {
		if(value < 0) return 0;
		if(value > 100000000) return 100000000;
		return value;
	}
}