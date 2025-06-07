package mk.ukim.finki.emt2025.web.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.emt2025.dto.CreateManufacturerDto;
import mk.ukim.finki.emt2025.dto.DisplayManufacturerDto;
import mk.ukim.finki.emt2025.service.application.ManufacturerApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
@Tag(name = "Manufacturer API", description = "Endpoints for managing manufacturers") // OpenAPI tag
public class ManufacturerController {

    private final ManufacturerApplicationService manufacturerApplicationService;

    public ManufacturerController(ManufacturerApplicationService manufacturerApplicationService) {
        this.manufacturerApplicationService = manufacturerApplicationService;
    }

    @Operation(
            summary = "Get all manufacturers", description = "Retrieves a list of all available manufacturers."
    )
    @GetMapping
    public List<DisplayManufacturerDto> findAll() {
        return manufacturerApplicationService.findAll();
    }

    @Operation(summary = "Get manufacturerId by ID", description = "Finds a manufacturerId by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayManufacturerDto> findById(@PathVariable Long id) {
        return manufacturerApplicationService.findById(id)
                                             .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayManufacturerDto> save(@RequestBody CreateManufacturerDto createManufacturerDto) {
        return manufacturerApplicationService.save(createManufacturerDto)
                                             .map(ResponseEntity::ok)
                                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an existing manufacturerId", description = "Updates a manufacturerId by ID.")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayManufacturerDto> update(
            @PathVariable Long id,
            @RequestBody CreateManufacturerDto createManufacturerDto
    ) {
        return manufacturerApplicationService.update(id, createManufacturerDto)
                                             .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a manufacturerId", description = "Deletes a manufacturerId by its ID.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (manufacturerApplicationService.findById(id).isPresent()) {
            manufacturerApplicationService.deleteById(id); return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}