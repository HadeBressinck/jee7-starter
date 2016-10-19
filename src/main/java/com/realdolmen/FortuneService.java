package com.realdolmen;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named("myFortuneService") // bean kan dan gecalled worden door jsf
public class FortuneService {

	@Inject
	@Profane
	private MessageSupplier messageSupplier;
	
	@Inject
	private Event<String> shitEvent; 
	
	public String fortune() {
		String message = messageSupplier.supplyRandomMessage();
		if (message.toLowerCase().contains("shit")) {
			shitEvent.fire(message);
		}
		return message;
	}
}
