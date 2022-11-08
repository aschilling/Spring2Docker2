package de.dhbw.ravensburg.cc.greeting.controller;


import de.dhbw.ravensburg.cc.greeting.service.GreetingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
public class GreetingRestControllerImpl implements GreetingRestController {

    private GreetingService greetingService;

    @Value("${Spring.profiles.active:dev}")
    private String stage;


    public GreetingRestControllerImpl(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @Override
    @GetMapping
    @Operation(summary = "Returns the customized greeting")
    public String getGreeting(@RequestParam(value = "apikey", defaultValue = "") @Parameter(description = "The apikey of the particular user") String apikey){

        //Abhängig von der gewählten Umgebungsvariable wird der übergebene username ausgegeben
        if (stage.trim().equals("dev")){
            log.info("Calling apikey is "+ apikey);
        }

        return this.greetingService.getGreeting();
    }

}
