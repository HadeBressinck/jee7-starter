package com.realdolmen;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "VerifiedPerson1")
public class VerifiedPerson1 extends Person1 {

	private LocalDateTime verificationDate;
	private Long verificationId;
	private int creditcard;

	public VerifiedPerson1() {
	}

	public VerifiedPerson1(String firstName, String lastName, String password, String email,
			LocalDateTime verificationDate, Long verificationId, int creditcard) {
		super(firstName, lastName, password, email);
		this.verificationDate = verificationDate;
		this.verificationId = verificationId;
		this.creditcard = creditcard;
	}

	public LocalDateTime getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(LocalDateTime verificationDate) {
		this.verificationDate = verificationDate;
	}

	public Long getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(Long verificationId) {
		this.verificationId = verificationId;
	}

	public int getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(int creditcard) {
		this.creditcard = creditcard;
	}

}
