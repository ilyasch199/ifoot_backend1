package ma.ifootback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ifootback.entities.*;
import ma.ifootback.repositories.*;

@Component
public class PitchServiceImpl implements PitchService{

	@Autowired
    private PitchRepository pitchRepository;
    
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public List<Pitch> findAll() {
        return pitchRepository.findAll();
    }

    @Override
    public Pitch findById(Long id) {
        return pitchRepository.findById(id).orElse(null);
    }

    @Override
    public Pitch createPitch(Pitch pitch, Location location, Picture picture) {
        location = locationRepository.save(location);
        pictureRepository.save(picture);
        return pitchRepository.save(pitch);
    }

    @Override
    public void delete(Pitch pitch) {
        pitchRepository.delete(pitch);
    }

	@Override
	public List<Pitch> findpitchownerpitches(User user) {
		return pitchRepository.findBypitchowner(user);
	}
}
