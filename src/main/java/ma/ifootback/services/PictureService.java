package ma.ifootback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ifootback.entities.Picture;

@Service
public interface PictureService {

    public List<Picture> findAll();
    public Picture findById(Long id);
    public Picture save(Picture picture);
    public void delete(Picture picture);
}
