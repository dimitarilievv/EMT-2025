package mk.ukim.finki.lab1b.jobs;

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
        entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW accommodations_by_host")
                .executeUpdate();
    }
}