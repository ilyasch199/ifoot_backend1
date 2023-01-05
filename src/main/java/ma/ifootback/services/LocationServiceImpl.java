package ma.ifootback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ifootback.entities.Location;
import ma.ifootback.repositories.LocationRepository;

@Component
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

	@Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

	@Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

	@Override
    public void delete(Location location) {
    	locationRepository.delete(location);
    }

}
