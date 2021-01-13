package org.vishwakarma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.vishwakarma.entity.Person;
import org.vishwakarma.entity.PersonDto;
import org.vishwakarma.service.PersonService;

@Path("/api/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {
	
	private final PersonService personService;
	
	@Inject
	PersonController(PersonService personService){
		this.personService = personService;
	}
	
	@GET
	public List<Person> getPersons(){
		return personService.getAllPerson();
	}
	
	@GET
	@Path("/{id}")
	public Person getPersonById(@PathParam long id) {
		return personService.getPersonById(id);
	}
	
	@POST
	@Transactional
	public Person savePerson(PersonDto personDto){
		return personService.savePerson(personDto.toPerson());
	}
	
	@PUT
	@Path("/{id}")
	public Person updatePerson(@PathParam long id, PersonDto personDto) {
		return personService.updatePerson(id,personDto.toPerson());
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletePerson(@PathParam long id) {
		personService.deletePerson(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
}
