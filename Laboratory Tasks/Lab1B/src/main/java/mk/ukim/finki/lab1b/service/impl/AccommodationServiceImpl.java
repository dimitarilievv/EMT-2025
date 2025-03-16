package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.dto.AccommodationDto;
import mk.ukim.finki.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.lab1b.service.AccommodationService;
import mk.ukim.finki.lab1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> save(AccommodationDto accommodationDto) {
        if(accommodationDto.getName()!=null && accommodationDto.getCategory()!=null
        && accommodationDto.getNumRooms()!=null &&
                hostService.findById(accommodationDto.getHost()).isPresent()){
            return Optional.of(accommodationRepository.save(new Accommodation(
                    accommodationDto.getName(),
                    accommodationDto.getCategory(),
                    hostService.findById(accommodationDto.getHost()).get(),
                    accommodationDto.getNumRooms()
            )));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> update(Long id, AccommodationDto accommodationDto) {
        return accommodationRepository.findById(id).map(existingAccommodation->{
           if(accommodationDto.getName()!=null)
               existingAccommodation.setName(accommodationDto.getName());
           if(accommodationDto.getCategory()!=null)
               existingAccommodation.setCategory(accommodationDto.getCategory());
           if(accommodationDto.getNumRooms()!=null)
               existingAccommodation.setNumRooms(accommodationDto.getNumRooms());
           if(accommodationDto.getHost()!=null && hostService.findById(accommodationDto.getHost()).isPresent())
               hostService.findById(accommodationDto.getHost()).get();
           return accommodationRepository.save(existingAccommodation);
        });
    }

    @Override
    public void deleteById(Long id) {
        Accommodation accommodation=accommodationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Accommodation not found with id"+id));
        accommodationRepository.delete(accommodation);
    }

//    @Override
//    public Optional<Accommodation> rentRoom(Long id, AccommodationDto accommodationDto) {
//        return accommodationRepository.findById(id).map(existingAccommodation->{
//            if(accommodationDto.getNumRooms()>0)
//                existingAccommodation.setNumRooms(existingAccommodation.getNumRooms()-1);
//            return accommodationRepository.save(existingAccommodation);
//        });
//    }
    @Override
    public Optional<Accommodation> rentRoom(Long id) {
        return accommodationRepository.findById(id).map(existingAccommodation->{
            if(existingAccommodation.getNumRooms()>0)
                existingAccommodation.setNumRooms(existingAccommodation.getNumRooms()-1);
            return accommodationRepository.save(existingAccommodation);
        });
    }
}
