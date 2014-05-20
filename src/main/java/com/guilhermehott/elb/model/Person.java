package com.guilhermehott.elb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Person {

	@Id
	@GenericGenerator(name = "GENERATOR", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "hibernate_sequence") })
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR")
	private Integer id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private Integer age;

	public Person() {
	}

	public Person(Integer id, String firstName, String lastName, Integer age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
