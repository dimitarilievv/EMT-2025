package mk.ukim.ukim.finki.emt2025.jobs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ViewRefresherService {
    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(cron = "0 0 * * * *")
    public void refreshView() {
        entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW books_by_author_mv")
                .executeUpdate();
    }
}

