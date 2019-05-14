package com.auspost.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class SuburbPostCode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonProperty("postCode")
	@Column(name = "postCode", unique = true)
	@Positive(message = "postcode must be a positive integer")
	private int postCode;

	@JsonProperty("suburb")
	private String suburb;

	public SuburbPostCode() {

	}

	public SuburbPostCode(@Positive(message = "postcode must be a positive integer") int postCode, String suburb) {
		super();
		this.postCode = postCode;
		this.suburb = suburb;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	@Override
	public String toString() {
		return "SuburbPostCode [id=" + id + ", postCode=" + postCode + ", suburb=" + suburb + "]";
	}

}
