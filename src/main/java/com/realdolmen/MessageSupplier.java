package com.realdolmen;

import java.util.List;
import java.util.Random;

public interface MessageSupplier {

	List<String> getMessages();

	default String supplyRandomMessage() {
		Random random = new Random();
		int index = random.nextInt(getMessages().size());
		return getMessages().get(index);
	}
}
