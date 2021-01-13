package org.vishwakarma.entity;

public class PersonDto {
	
	String name;
	String birth;
	boolean status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Person toPerson() {
		Person person = new Person();
		person.setBirth(birth);
		person.setName(name);
		person.setStatus(status);
		return person;
	}
}
