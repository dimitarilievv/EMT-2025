package mk.ukim.finki.emt2025.dto;

import mk.ukim.finki.emt2025.model.domain.Manufacturer;

public record CreateManufacturerDto(String name, String address) {

    public Manufacturer toManufacturer() {
        return new Manufacturer(name, address);
    }
}