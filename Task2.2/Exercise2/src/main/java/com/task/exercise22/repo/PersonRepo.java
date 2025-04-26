package com.task.exercise22.repo;

import com.task.exercise22.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepo implements PanacheRepository<Person> {

}
