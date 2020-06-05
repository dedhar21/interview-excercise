package com.acme.mytrader.price.Impl;

import com.acme.mytrader.price.PriceListener;

public class PriceListenerImpl implements PriceListener {

	private String buyOrSell;
	private Double triggerPrice;
	private String security;

	@Override
	public void priceUpdate(String security, double price) {
		this.security = security;
		this.triggerPrice = price;
	}

	public void setBuyOrSell(String buyOrSell) {
		this.buyOrSell = buyOrSell;
	}

	@Override
	public String getBuyOrSell() {
		return this.buyOrSell;
	}

	@Override
	public Double getTriggerPrice() {
		return triggerPrice;
	}

	public void setTriggerPrice(Double triggrPrice) {
		this.triggerPrice = triggrPrice;
	}

	@Override
	public String getSecurity() {
		return this.security;
	}

	@Override
	public String toString() {
		return "PriceListenerImpl [buyOrSell=" + buyOrSell + ", triggerPrice=" + triggerPrice + ", security=" + security
				+ "]";
	}

}
