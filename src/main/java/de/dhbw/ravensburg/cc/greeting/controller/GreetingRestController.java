package de.dhbw.ravensburg.cc.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface GreetingRestController {
    @GetMapping
    String getGreeting(String apikey);

}
