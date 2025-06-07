package mk.ukim.finki.emt2025.service.domain;

import mk.ukim.finki.emt2025.model.domain.Product;
import mk.ukim.finki.emt2025.model.domain.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    Optional<ShoppingCart> getActiveShoppingCart(String username);

    Optional<ShoppingCart> addProductToShoppingCart(String username, Long productId);
}

