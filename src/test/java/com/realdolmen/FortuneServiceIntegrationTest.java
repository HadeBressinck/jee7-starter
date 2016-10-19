package com.realdolmen;

import static org.junit.Assert.*;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

public class FortuneServiceIntegrationTest {

	private WeldContainer container;
	
	@Before
	public void init() {
		Weld weld = new Weld();
		container = weld.initialize();
	}
	
	@Test
	public void fortuneYieldsProfaneMessage() {
		FortuneService fs = container.instance().select(FortuneService.class).get();
		String message = fs.fortune();
		System.out.println(message);
		assertNotNull(message); //Reasonable proof
	}
}
