package mk.ukim.ukim.finki.emt2025.listeners;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mk.ukim.ukim.finki.emt2025.events.AuthorChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthorChangedListener {
    private final JdbcTemplate jdbcTemplate;

    public AuthorChangedListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void handleHostChanged(AuthorChangedEvent event) {
        jdbcTemplate.execute("REFRESH MATERIALIZED VIEW authors_by_country_mv");
    }
}
