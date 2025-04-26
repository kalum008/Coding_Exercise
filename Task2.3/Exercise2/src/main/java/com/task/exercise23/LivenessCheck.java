package com.task.exercise23;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class LivenessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        if(checkServiceAvailable()){
            return HealthCheckResponse.up("Service is Up");
        }else{
            return HealthCheckResponse.down("Service is down");
        }
    }

    private boolean checkServiceAvailable(){
        return true;
    }
}
