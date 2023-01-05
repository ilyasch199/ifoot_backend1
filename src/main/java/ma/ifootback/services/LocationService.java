package ma.ifootback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ifootback.entities.Location;

@Service
public interface LocationService {

    public List<Location> findAll();
    public Location findById(Long id);
    public Location save(Location location);
    public void delete(Location location);
}
