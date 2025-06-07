package mk.ukim.finki.emt2025.service.application;

import mk.ukim.finki.emt2025.dto.CreateUserDto;
import mk.ukim.finki.emt2025.dto.DisplayUserDto;
import mk.ukim.finki.emt2025.dto.LoginResponseDto;
import mk.ukim.finki.emt2025.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
