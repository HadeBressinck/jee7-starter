package com.realdolmen;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ageCategory;
	private List<String> intrest;
	private String familyState;

	public Profile() {
	}

	public Profile(String ageCategory, List<String> intrest, String familyState) {
		this.ageCategory = ageCategory;
		this.intrest = intrest;
		this.familyState = familyState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(String ageCategory) {
		this.ageCategory = ageCategory;
	}

	public List<String> getIntrest() {
		return intrest;
	}

	public void setIntrest(List<String> intrest) {
		this.intrest = intrest;
	}

	public String getFamilyState() {
		return familyState;
	}

	public void setFamilyState(String familyState) {
		this.familyState = familyState;
	}

}
