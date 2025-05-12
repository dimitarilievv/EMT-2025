package mk.ukim.finki.lab1b.service.application.impl;

import mk.ukim.finki.lab1b.dto.CreateHostDto;
import mk.ukim.finki.lab1b.dto.DisplayHostDto;
import mk.ukim.finki.lab1b.events.HostChangedEvent;
import mk.ukim.finki.lab1b.projections.HostByCountry;
import mk.ukim.finki.lab1b.projections.HostNameProjection;
import mk.ukim.finki.lab1b.service.application.HostApplicationService;
import mk.ukim.finki.lab1b.service.domain.HostService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    private final ApplicationEventPublisher eventPublisher;

    public HostApplicationServiceImpl(HostService hostService, ApplicationEventPublisher eventPublisher) {
        this.hostService = hostService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return hostService.findAll().stream().map(DisplayHostDto::from).toList();
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto host) {
        Optional<DisplayHostDto> saved = hostService.save(host.toHost())
                .map(DisplayHostDto::from);

        saved.ifPresent(dto -> eventPublisher.publishEvent(new HostChangedEvent(this)));

        return saved;
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto host) {
        Optional<DisplayHostDto> updated = hostService.update(id,host.toHost())
                .map(DisplayHostDto::from);

        updated.ifPresent(dto -> eventPublisher.publishEvent(new HostChangedEvent(this)));

        return updated;
    }

    @Override
    public void deleteById(Long id) {
        hostService.deleteById(id);
        eventPublisher.publishEvent(new HostChangedEvent(this));
    }

    @Override
    public List<HostByCountry> getHostCountByCountry() {
        return hostService.getHostCountByCountry();
    }

    @Override
    public List<HostNameProjection> getAllHostNames() {
        return hostService.getAllHostNames();
    }

}
