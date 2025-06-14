package mk.ukim.finki.emt2025.dto;

import mk.ukim.finki.emt2025.model.domain.ShoppingCart;
import mk.ukim.finki.emt2025.model.enumerations.ShoppingCartStatus;

import java.time.LocalDateTime;
import java.util.List;

public record ShoppingCartDto(
        Long id,
        LocalDateTime dateCreated,
        DisplayUserDto user,
        List<DisplayProductDto> products,
        ShoppingCartStatus status
) {

    public static ShoppingCartDto from(ShoppingCart shoppingCart) {
        return new ShoppingCartDto(
                shoppingCart.getId(),
                shoppingCart.getDateCreated(),
                DisplayUserDto.from(shoppingCart.getUser()),
                DisplayProductDto.from(shoppingCart.getProducts()),
                shoppingCart.getStatus()
        );
    }
}
