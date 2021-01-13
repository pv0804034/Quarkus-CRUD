package org.vishwakarma.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.vishwakarma.entity.Person;
import org.vishwakarma.repository.PersonRepository;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	@Inject
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> getAllPerson() {
		return personRepository.listAll();
	}

	@Override
	public Person getPersonById(long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person savePerson(Person person) {
		personRepository.persistAndFlush(person);
		return person;
	}

	@Override
	@Transactional
	public Person updatePerson(long id, Person person) {
		Person existingPerson = getPersonById(id);
		existingPerson.setBirth(person.getBirth());
		existingPerson.setName(person.getName());
		existingPerson.setStatus(person.getStatus());
		personRepository.persist(existingPerson);
		return existingPerson;
	}

	@Override
	@Transactional
	public void deletePerson(long id) {
		personRepository.delete(getPersonById(id));
	}
}
