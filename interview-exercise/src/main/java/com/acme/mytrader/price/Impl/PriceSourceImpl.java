package com.acme.mytrader.price.Impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import com.acme.mytrader.execution.Impl.ExecutionServiceImpl;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;

public class PriceSourceImpl implements PriceSource {

	private ExecutionServiceImpl execution = new ExecutionServiceImpl();
	List<PriceListener> listeners = new CopyOnWriteArrayList<PriceListener>();

	@Override
	public void addPriceListener(PriceListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removePriceListener(PriceListener listener) {
		this.listeners = listeners.stream().filter(listn -> !(listn.getSecurity().equals(listener.getSecurity()) &&
																listn.getBuyOrSell().equals(listener.getBuyOrSell()) &&
																listn.getTriggerPrice().equals(listener.getTriggerPrice())))
				.collect(Collectors.toList());
	}

	@Override
	public void execute(double currentMarketPrice) {
		listeners.forEach(listener -> {
			if ("BUY".equals(listener.getBuyOrSell()) && currentMarketPrice == listener.getTriggerPrice()) {
				execution.buy(listener.getSecurity(), listener.getTriggerPrice(), 10);
				removePriceListener(listener);
			}

			if ("SELL".equals(listener.getBuyOrSell()) && currentMarketPrice == listener.getTriggerPrice()) {
				execution.sell(listener.getSecurity(), listener.getTriggerPrice(), 10);
				removePriceListener(listener);
			}
		});
	}

}
