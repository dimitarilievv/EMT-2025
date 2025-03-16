package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.model.dto.HostDto;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Optional<Host> save(HostDto hostDto);
    Optional<Host> update(Long id,HostDto hostDto);
    void deleteById(Long id);
}
