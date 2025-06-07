package mk.ukim.finki.emt2025.jobs;

import mk.ukim.finki.emt2025.service.domain.ProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final ProductService productService;

    public ScheduledTasks(ProductService productService) {
        this.productService = productService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void refreshMaterializedView() {
//        this.productService.refreshMaterializedView();
    }
}

