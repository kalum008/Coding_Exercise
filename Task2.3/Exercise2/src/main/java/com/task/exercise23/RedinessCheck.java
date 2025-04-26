package com.task.exercise23;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class RedinessCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        if(checkRediness()){
            return HealthCheckResponse.up("Service is Ready");
        }else{
            return HealthCheckResponse.down("Service is not Ready");
        }
    }

    public boolean checkRediness(){
        return true;
    }
}
