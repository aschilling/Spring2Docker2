package de.dhbw.ravensburg.cc.greeting.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public String getGreeting(){
        //Für "prod" Profil bitte deutsche Übersetzung zurückgeben:
        return "Herzlich Willkommen zur Veranstaltung Cloud Computing";

        //Für "test" Profil bitte englische Übersetzung zurückgeben:
        // --> "Wellcome to the course on cloud computing";

        //Für "dev" Profil bitte französische Übersetzung zurückgeben:
        // --> "Bienvenue au cours sur le cloud computing"

    }

}
