package be.thomasmore.party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication              //zegt het Spring framework dat het Spring-magic moet gebr om de app op te starten
public class PartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartyApplication.class, args);
    }       //

}
