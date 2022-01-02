package com.TaeliaDideaux.rcreloaded.boltcurrency;

public interface ICurrencyCapability {
	
	int getBolts();
	
	void setBolts(int value);
	
	default void addBolts(int value) { this.setBolts(this.getBolts() + value); }
	default void useBolts(int value) { this.setBolts(this.getBolts() - value); }
}
