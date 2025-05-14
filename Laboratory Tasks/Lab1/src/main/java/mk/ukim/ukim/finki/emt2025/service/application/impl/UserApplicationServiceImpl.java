package mk.ukim.ukim.finki.emt2025.service.application.impl;

import mk.ukim.ukim.finki.emt2025.dto.*;
import mk.ukim.ukim.finki.emt2025.model.domain.Book;
import mk.ukim.ukim.finki.emt2025.model.domain.User;
import mk.ukim.ukim.finki.emt2025.security.JwtHelper;
import mk.ukim.ukim.finki.emt2025.service.application.UserApplicationService;
import mk.ukim.ukim.finki.emt2025.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;
    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }
    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));
    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(

                loginUserDto.username(),
                loginUserDto.password()
        );

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginResponseDto(token));
    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }

    @Override
    public List<DisplayBookDto> addBookToWishlist(String username, Long bookId) {
        User user = userService.findByUsername(username);
        userService.addBookToWishList(username,bookId);
        List<Book> books = user.getWishListBooks();
        return books.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public List<DisplayBookDto> getUserWishList(String username) {
        return userService.getUserWishList(username)
                .stream()
                .map(DisplayBookDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<DisplayBookCopyDto> rentAllCopiesFromWishList(String username) {
        return userService.rentAllCopiesFromWishList(username).stream().map(DisplayBookCopyDto::from).collect(Collectors.toList());
    }

}
