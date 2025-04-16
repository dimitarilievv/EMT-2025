package mk.ukim.finki.lab1b.service.application;


import mk.ukim.finki.lab1b.dto.CreateUserDto;
import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.dto.DisplayUserDto;
import mk.ukim.finki.lab1b.dto.LoginUserDto;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
    List<DisplayAccommodationDto> addAccommodationToTempList(String username, Long accommodationId);
    List<DisplayAccommodationDto> getUserTempList(String username);
    List<DisplayAccommodationDto> rentAllAccommodationsFromTempList(String username);
}