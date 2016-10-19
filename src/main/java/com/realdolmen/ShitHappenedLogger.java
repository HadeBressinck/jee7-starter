package com.realdolmen;

import javax.enterprise.event.Observes;

public class ShitHappenedLogger {
	
	private int count = 0;
	
	public void addShitMessage(@Observes @Shit ShitHappened shitHappened) {
		count++;
	}
	
}
