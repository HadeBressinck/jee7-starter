package com.realdolmen;

import java.util.List;

import javax.enterprise.inject.Produces;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageListFactory {

	
	@Produces
	@Prude
	public List<String> createSomeMessages() {
			return Arrays.asList("Good morning!",
					"An apple a day keeps the doctor away",
					"You won't get struck by lightning! Yay!");
		}
		
	
}
