package com.realdolmen;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//maakt dat unique
	private Long Id;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	private List<TweetForDb> tweets;

	protected Tag() {
	}

	public Tag(String name) {
		this.setName(name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
