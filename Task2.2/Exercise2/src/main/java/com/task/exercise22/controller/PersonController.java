package com.task.exercise22.controller;

import com.task.exercise22.entity.Person;
import com.task.exercise22.repo.PersonRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {

    @Inject
    PersonRepo personRepo;

    @POST
    public Response createPerson(Person person){
        personRepo.persist(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    @GET
    public List<Person> listOfPerson(){
        return personRepo.listAll();
    }

    @GET
    @Path("/search/{name}")
    public Response findPersonByName(@PathParam("name") String name){
        Person person= personRepo.find("name",name).firstResult();
        if(person == null){
            Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(person).build();
    }
}
