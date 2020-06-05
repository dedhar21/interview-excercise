package com.acme.mytrade;

import java.util.Arrays;
import java.util.List;

public class TradingApp {

	public static void main(String[] args) {
			
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);
		
		values.forEach(value -> {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}

}
