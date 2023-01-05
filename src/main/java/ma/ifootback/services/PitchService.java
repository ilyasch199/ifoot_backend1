package ma.ifootback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ifootback.entities.*;

@Service
public interface PitchService {

	public List<Pitch> findAll();
    public Pitch findById(Long id);
    public Pitch createPitch(Pitch pitch, Location location, Picture pictures);
    public void delete(Pitch pitch);
    public List<Pitch> findpitchownerpitches(User user);
}
