package com.acme.mytrader.strategy;

import java.util.Arrays;
import java.util.List;

import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.Impl.PriceListenerImpl;
import com.acme.mytrader.price.Impl.PriceSourceImpl;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

	public static void main(String[] args) {

		PriceSource priceSource = new PriceSourceImpl();

		// SBI BUY
		PriceListenerImpl buySBI = new PriceListenerImpl();
		buySBI.priceUpdate("SBI", 4.0);
		buySBI.setBuyOrSell("BUY");
		priceSource.addPriceListener(buySBI);

		// ICICI BUY
		PriceListenerImpl buyICICI = new PriceListenerImpl();
		buyICICI.priceUpdate("ICICI", 3.0);
		buyICICI.setBuyOrSell("BUY");
		priceSource.addPriceListener(buyICICI);

		// ICICI SELL
		PriceListenerImpl sellICICI = new PriceListenerImpl();
		sellICICI.priceUpdate("ICICI", 5.0);
		sellICICI.setBuyOrSell("SELL");
		priceSource.addPriceListener(sellICICI);

		// SBI SELL
		PriceListenerImpl sellSBI = new PriceListenerImpl();
		sellSBI.priceUpdate("SBI", 8.0);
		sellSBI.setBuyOrSell("SELL");
		priceSource.addPriceListener(sellSBI);

		// YESBANK BUY
		PriceListenerImpl buyYESBANK = new PriceListenerImpl();
		buyYESBANK.priceUpdate("YESBANK", 2.0);
		buyYESBANK.setBuyOrSell("BUY");
		priceSource.addPriceListener(buyYESBANK);

		List<Double> currentMarketPrices = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
		currentMarketPrices.forEach(currentMarketPrice -> {
			try {
				Thread.sleep(2000L);
				priceSource.execute(currentMarketPrice);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

	}
}
