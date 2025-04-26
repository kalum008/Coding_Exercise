package com.task.exercise21;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greet(String name,String suffix){
        return "Hello " + name + (suffix!= null && !suffix.isEmpty() ? " " +suffix : "");
    }
}
