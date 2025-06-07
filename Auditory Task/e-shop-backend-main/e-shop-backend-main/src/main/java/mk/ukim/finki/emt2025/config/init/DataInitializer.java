package mk.ukim.finki.emt2025.config.init;

import mk.ukim.finki.emt2025.model.domain.Category;
import mk.ukim.finki.emt2025.model.domain.Manufacturer;
import mk.ukim.finki.emt2025.model.domain.User;
import mk.ukim.finki.emt2025.model.enumerations.Role;
import mk.ukim.finki.emt2025.repository.CategoryRepository;
import mk.ukim.finki.emt2025.repository.ManufacturerRepository;
import mk.ukim.finki.emt2025.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            CategoryRepository categoryRepository,
            ManufacturerRepository manufacturerRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @PostConstruct
    public void init() {
        categoryRepository.save(new Category("Sports", "Sports categoryId"));
        categoryRepository.save(new Category("Food", "Food categoryId"));
        categoryRepository.save(new Category("Music", "Music categoryId"));

        manufacturerRepository.save(new Manufacturer("Nike", "USA"));
        manufacturerRepository.save(new Manufacturer("KFC", "USA"));
        manufacturerRepository.save(new Manufacturer("A Records", "UK"));

        userRepository.save(new User(
                "at",
                passwordEncoder.encode("at"),
                "Ana",
                "Todorovska",
                Role.ROLE_ADMIN
        ));

        userRepository.save(new User(
                "user",
                passwordEncoder.encode("user"),
                "user",
                "user",
                Role.ROLE_USER
        ));
    }
}