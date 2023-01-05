package ma.ifootback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ifootback.entities.Picture;
import ma.ifootback.repositories.PictureRepository;

@Component
public class PictureServiceImpl implements PictureService{

	@Autowired
	private PictureRepository pictureRepository;
	
	@Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

	@Override
    public Picture findById(Long id) {
        return pictureRepository.findById(id).orElse(null);
    }

	@Override
    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }

	@Override
    public void delete(Picture picture) {
    	pictureRepository.delete(picture);
    }
}
