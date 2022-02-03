package dev.piotrjanik;

import io.micronaut.http.annotation.*;

@Controller("/simplySilly")
public class SimplySillyController {

    @Get(uri = "/", produces = "text/plain")
    public String index() {
        return "Example Response";
    }
}
