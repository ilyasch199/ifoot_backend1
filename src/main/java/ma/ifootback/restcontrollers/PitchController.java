package ma.ifootback.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ifootback.services.PitchServiceImpl;
import ma.ifootback.services.UserServiceImpl;
import ma.ifootback.entities.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pitches")
public class PitchController {

  @Autowired
  private PitchServiceImpl pitchService;
  
  @Autowired
  private UserServiceImpl userService;
  
  @GetMapping
  public List<Pitch> findAll() {
      return pitchService.findAll();
  }

  @GetMapping("/{id}")
  public Pitch findById(@PathVariable Long id) {
      return pitchService.findById(id);
  }

  @PostMapping("/addpitch")
  public Pitch createPitch(@RequestParam("latitude") Float latitude,@RequestParam("longitude") Float longitude,
		  @RequestParam("image") String image,@RequestParam("iduser") Long id_user,@RequestParam("name") String name,
		  @RequestParam("address") String address,@RequestParam("city") String city,@RequestParam("format") String format,
		  @RequestParam("price") Float price, @RequestParam("heureopen") String heureopen,@RequestParam("heureclose") String heureclose) {
	  Pitch pitch = new Pitch();
	  
	  Location location = new Location();
      location.setLatitude(latitude);
      location.setLongitude(longitude);
      pitch.setLocation(location);
      
      Picture p = new Picture(image);
      
      pitch.setPicture(p);
      pitch.setName(name);
      pitch.setAddress(address);
      pitch.setCity(city);
      pitch.setFormat(format);
      pitch.setPrice(price);
      pitch.setHeure_open(heureopen);
      pitch.setHeure_close(heureclose);
      
      User user = userService.findById(id_user);
      pitch.setUser(user);

      return pitchService.createPitch(pitch, location, p);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
      Pitch pitch = pitchService.findById(id);
      pitchService.delete(pitch);
  }
  
  @GetMapping("/pitchowner/{iduser}")
  public List<Pitch> pitchesbypitchowner(@PathVariable Long iduser) {
	  User user = userService.findById(iduser);
	  return pitchService.findpitchownerpitches(user);
  }

}
