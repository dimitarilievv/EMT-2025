package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.domain.Accommodation;
import mk.ukim.finki.lab1b.model.domain.Host;
import mk.ukim.finki.lab1b.model.enumerations.Category;

public record CreateAccommodationDto(String name, Category category, Host host, Integer numRooms) {
    public Accommodation toAccommodation(){
        return new Accommodation(name,category,host,numRooms);
    }
}
