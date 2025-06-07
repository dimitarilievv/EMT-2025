package mk.ukim.finki.emt2025.dto;

import mk.ukim.finki.emt2025.model.domain.Manufacturer;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayManufacturerDto(Long id, String name, String address) {

    public static DisplayManufacturerDto from(Manufacturer manufacturer) {
        return new DisplayManufacturerDto(manufacturer.getId(), manufacturer.getName(), manufacturer.getAddress());
    }

    public static List<DisplayManufacturerDto> from(List<Manufacturer> manufacturers) {
        return manufacturers.stream()
                            .map(DisplayManufacturerDto::from)
                            .collect(Collectors.toList());
    }
}