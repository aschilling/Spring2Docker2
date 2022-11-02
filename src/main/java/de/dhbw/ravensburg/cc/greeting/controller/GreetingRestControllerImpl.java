package de.dhbw.ravensburg.cc.greeting.controller;


import de.dhbw.ravensburg.cc.greeting.service.GreetingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/api/greetings")
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
    public String getGreeting(@RequestParam(value = "lang",defaultValue = "de") @Parameter(description = "The prefered language for which the wellcome message will be adopted.") String lang,
                              @RequestHeader(value = "username", defaultValue = "") @Parameter(description = "The username of the particular user") String username,
                              @RequestHeader(value = "apikey", defaultValue = "") @Parameter(description = "The apikey of the particular user") String apikey){

        //Abhängig von der gewählten Umgebungsvariable wird der übergebene username ausgegeben
        if (stage.trim().equals("dev")){
            log.info("Calling user is "+ username);
        }

        return this.greetingService.getGreeting(lang);
    }

    @Override
    @GetMapping("/version")
    @Operation(summary = "Returns the current version of the service")
    public String getVersion(){
        return this.greetingService.getVersion();
    }

}
