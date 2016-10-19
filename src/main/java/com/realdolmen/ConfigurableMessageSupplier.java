package com.realdolmen;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class ConfigurableMessageSupplier implements MessageSupplier {

	private List<String> messages;
	
	@Inject
	public ConfigurableMessageSupplier(@Prude List<String> messages) {
		this.messages = messages;
	}
	
	@Override
	public List<String> getMessages() {
		return this.messages;
	}

}
