package com.acme.mytrader.execution.Impl;

import java.util.HashMap;
import java.util.Map;

import com.acme.mytrader.execution.ExecutionService;

public class ExecutionServiceImpl implements ExecutionService {

	Map<String, Integer> securityToVolumeMap = new HashMap<>();

	@Override
	public void buy(String security, double price, int volume) {
		Integer initialVolume = securityToVolumeMap.get(security);
		if(initialVolume == null) {
			initialVolume = 0;
		}
		securityToVolumeMap.put(security, initialVolume + volume);
		//"\n"+security + " bought of volume of "+ volume + " for the price of "+price
		print();
	}

	@Override
	public void sell(String security, double price, int volume) {
		Integer initialVolume = securityToVolumeMap.get(security);
		if (initialVolume != null && initialVolume >= volume) {
			if ((initialVolume - volume) == 0) {
				securityToVolumeMap.remove(security);
			} else  {
				securityToVolumeMap.put(security, initialVolume - volume);
			}
		} else {
			//"No available volumes"
		}
		//"\n"+security + " sold of volume of "+ volume + " for the price of "+price;
	}

	private void print() {
		//("\n----------------Holdings--------------");
		securityToVolumeMap.forEach((k, v) -> {
			//"Name = " + k + ", Volume = " + v;
		});
		
	}

}
