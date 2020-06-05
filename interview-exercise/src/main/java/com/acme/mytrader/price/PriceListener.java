package com.acme.mytrader.price;

public interface PriceListener {

	void priceUpdate(String security, double price);

	String getBuyOrSell();

	Double getTriggerPrice();
	
	String getSecurity();
}
