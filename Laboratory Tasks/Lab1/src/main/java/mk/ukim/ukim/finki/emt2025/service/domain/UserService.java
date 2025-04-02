package mk.ukim.ukim.finki.emt2025.service.domain;

import mk.ukim.ukim.finki.emt2025.model.domain.User;
import mk.ukim.ukim.finki.emt2025.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);
}
