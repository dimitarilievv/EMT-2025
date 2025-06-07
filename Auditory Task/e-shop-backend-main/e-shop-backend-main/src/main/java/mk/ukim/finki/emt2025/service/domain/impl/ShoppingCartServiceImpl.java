package mk.ukim.finki.emt2025.service.domain.impl;

import mk.ukim.finki.emt2025.model.domain.Product;
import mk.ukim.finki.emt2025.model.domain.ShoppingCart;
import mk.ukim.finki.emt2025.model.domain.User;
import mk.ukim.finki.emt2025.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.emt2025.model.exceptions.ProductAlreadyInShoppingCartException;
import mk.ukim.finki.emt2025.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt2025.model.exceptions.ShoppingCartNotFoundException;
import mk.ukim.finki.emt2025.repository.ShoppingCartRepository;
import mk.ukim.finki.emt2025.service.domain.ProductService;
import mk.ukim.finki.emt2025.service.domain.ShoppingCartService;
import mk.ukim.finki.emt2025.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserService userService;
    private final ProductService productService;

    public ShoppingCartServiceImpl(
            ShoppingCartRepository shoppingCartRepository,
            UserService userService,
            ProductService productService
    ) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if (shoppingCartRepository.findById(cartId).isEmpty())
            throw new ShoppingCartNotFoundException(cartId);
        return shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public Optional<ShoppingCart> getActiveShoppingCart(String username) {
        User user = userService.findByUsername(username);

        return Optional.of(shoppingCartRepository.findByUserAndStatus(
                user,
                ShoppingCartStatus.CREATED
        ).orElseGet(() -> shoppingCartRepository.save(new ShoppingCart(user))));
    }

    @Override
    public Optional<ShoppingCart> addProductToShoppingCart(String username, Long productId) {
        if (getActiveShoppingCart(username).isPresent()) {
            ShoppingCart shoppingCart = getActiveShoppingCart(username).get();

            Product product = productService.findById(productId)
                    .orElseThrow(() -> new ProductNotFoundException(productId));
            if (!shoppingCart.getProducts().stream().filter(i -> i.getId().equals(productId)).toList().isEmpty())
                throw new ProductAlreadyInShoppingCartException(productId, username);
            shoppingCart.getProducts().add(product);
            return Optional.of(shoppingCartRepository.save(shoppingCart));
        }
        return Optional.empty();
    }
}
