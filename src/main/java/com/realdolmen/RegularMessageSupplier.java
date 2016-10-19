package com.realdolmen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Prude
public class RegularMessageSupplier implements MessageSupplier {
	
	private List<String> messages = Arrays.asList(
			"Good morning!",
			"An apple a day keeps the doctor away",
			"You won't get struck by lightning! Yay!");
	
	@Override
	public List<String> getMessages() {
		return messages;
	}
}
