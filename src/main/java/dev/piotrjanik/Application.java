package dev.piotrjanik;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Label;
import io.dekorate.kubernetes.annotation.Port;
import io.dekorate.kubernetes.annotation.Probe;

@OpenAPIDefinition(
        info = @Info(
                title = "simply-silly",
                version = "0.0"
        )
)
@KubernetesApplication(
        name = "simply-silly",
        labels = @Label(key = "app", value = "simply-silly"),
        ports = @Port(name = "http", containerPort = 8080),
        livenessProbe = @Probe(httpActionPath = "/health/liveness", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10),
        readinessProbe = @Probe(httpActionPath = "/health/readiness", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10)
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
