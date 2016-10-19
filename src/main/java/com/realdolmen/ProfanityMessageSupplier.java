package com.realdolmen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Profane
public class ProfanityMessageSupplier implements MessageSupplier {
	
	private List<String> messages = Arrays.asList(
			"F*ck this shit, I'm going home!",
			"You moron!",
			"I'm with stupid...");
	
	@Override
	public List<String> getMessages() {
		return messages;
	}
}
