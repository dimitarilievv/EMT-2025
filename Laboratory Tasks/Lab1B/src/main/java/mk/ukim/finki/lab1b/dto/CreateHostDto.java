package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.domain.Country;
import mk.ukim.finki.lab1b.model.domain.Host;

public record CreateHostDto(String name, String surname, Country country) {
    public Host toHost(){
        return new Host(name,surname,country);
    }
}
