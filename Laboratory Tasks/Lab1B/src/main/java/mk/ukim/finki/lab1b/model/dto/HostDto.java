package mk.ukim.finki.lab1b.model.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.lab1b.model.Country;

@Data
public class HostDto {
    private String name;
    private String surname;
    private Long country;

    public HostDto(String name, String surname, Long country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
