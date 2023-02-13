package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FullName {

	@Column(name="First_Name",length = 50,nullable = false)
	private String firstName;
	@Column(name="Last_Name",length = 50,nullable = false)
	private String lastName;
	@Column(name="First_Name",length = 50,nullable = true)
	private String middleName;
}
