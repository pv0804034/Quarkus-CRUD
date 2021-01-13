package org.vishwakarma.service;

import java.util.List;

import org.vishwakarma.entity.Person;

public interface PersonService {
	
	List<Person> getAllPerson();
	
	Person getPersonById(long id);
	
	Person savePerson(Person person);
	
	Person updatePerson(long id, Person person);
	
	void deletePerson(long id);
}
