package com.realdolmen;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "RegularPerson1")
public class RegularPerson1 extends Person1 {

	@OneToOne
	private Profile profile;

	public RegularPerson1() {
	}

	public RegularPerson1(Profile profile, String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		this.profile = profile;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
