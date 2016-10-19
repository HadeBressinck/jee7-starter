package com.realdolmen;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Set;

public class TweetTest {

	private ValidatorFactory factory;
	private Validator validator;

	@Before
	public void initValidatorInfrastructure() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@After
	public void destroyValidatorInfrastructure() {
		factory.close();
	}

	@Test
	public void dateMustBeInThePast() throws Exception {
		Tweet t = new Tweet("Johnny", "What a beautiful weather it is, today!", "tagggietag");
		Thread.sleep(10);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t);
		Assert.assertEquals(0, violations.size());
		System.out.println(violations);
	}

	@Test
	public void usernameIsMandatory() {
		Tweet t = new Tweet(null, "Blablabla my tweet message");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(t, Tags.class, Default.class);
		Assert.assertEquals(2, violations.size());
		System.out.println(violations);
		ConstraintViolation<Tweet> error = violations.iterator().next();
		Assert.assertEquals("may not be null", error.getMessage());
		System.out.println(violations);
	}
}
