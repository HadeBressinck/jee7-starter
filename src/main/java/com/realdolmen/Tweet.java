package com.realdolmen;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Tweet {


	@Past
	private Date date;

	@NotNull
	@Size(min = 2)
	private String username;

	@NotNull
	@Size(max = 140)
	private String message;
	@NotNull
	@Size(min = 1, groups = Tags.class)
	private Set<String> tags;

	public Tweet(String username, String message, String... tags) {
		this.date = new Date();
		this.username = username;
		this.message = message;
		this.tags = new TreeSet<>(Arrays.asList(tags)); // ordered set met
														// TreeSet

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}
