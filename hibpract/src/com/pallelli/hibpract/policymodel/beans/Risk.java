package com.pallelli.hibpract.policymodel.beans;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Risk {

	private String name;

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
