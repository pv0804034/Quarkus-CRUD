package org.vishwakarma.repository;

import javax.enterprise.context.ApplicationScoped;

import org.vishwakarma.entity.Person;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person>{
	
}
