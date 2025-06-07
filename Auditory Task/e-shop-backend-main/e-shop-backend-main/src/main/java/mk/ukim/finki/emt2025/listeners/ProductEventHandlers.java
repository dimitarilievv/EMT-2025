package mk.ukim.finki.emt2025.listeners;

import mk.ukim.finki.emt2025.events.ProductCreatedEvent;
import mk.ukim.finki.emt2025.service.domain.ProductService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandlers {

    private final ProductService productService;

    public ProductEventHandlers(ProductService productService) {
        this.productService = productService;
    }

    @EventListener
    public void onProductCreated(ProductCreatedEvent event) {
        this.productService.refreshMaterializedView();
    }
}

