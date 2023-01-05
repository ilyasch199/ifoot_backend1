package ma.ifootback.restcontrollers;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.ifootback.entities.User;
import ma.ifootback.services.UserServiceImpl;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
    private UserServiceImpl userService;
	
    @RequestMapping(method = RequestMethod.GET,path = "/test")
    public String hello() {   
    	return "Hello, world"; 
    }
    
  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestParam("email") String email, @RequestParam("password") String password) {
  	User user = userService.checkLoginwithemail(email, password);
  	if (user == null) {
  	   return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  	  }
  	   return ResponseEntity.ok(user);
  }
  
  @GetMapping
  public List<User> getAllUsers() {
      return userService.findAll();
  }
  
  @GetMapping("/players")
  public List<User> getplayers() {
      return userService.findPlayers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
      return userService.findById(id);
  }

  @PostMapping("/adduser")
  public User createUser(@RequestParam(value = "name", required = true) String name,@RequestParam(value = "email", required = false) String email,
  		@RequestParam(value = "password", required = false) String password,@RequestParam(value = "phone", required = true) String phone,
  		@RequestParam(value = "datebirth", required = false) String date_of_birth,@RequestParam(value = "city", required = true) String city,
  		@RequestParam(value = "country", required = true) String country,@RequestParam(value = "smprovider", required = false) String social_media_provider,
  		@RequestParam(value = "smuserid", required = false) String social_media_userid,@RequestParam(value = "role", required = true) int role) throws ParseException{
  	User user = new User();
  	LocalDateTime localDateTime = LocalDateTime.now();
  	Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
  	Date date = Date.from(instant);
  	Date datebirth=new SimpleDateFormat("dd/MM/yyyy").parse(date_of_birth);
  	user.setCity(city);
  	user.setCountry(country);
  	user.setEmail(email);
  	user.setCreated_at(date);
  	user.setDate_of_birth(datebirth);
  	user.setName(name);
  	user.setPassword(password);
  	user.setPhone(phone);
  	user.setRole(role);
  	user.setSocial_media_provider(social_media_provider);
  	user.setSocial_media_userid(social_media_userid);
      return userService.save(user);
  }

  @PutMapping("/updateuser/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    User updatedUser = userService.update(user);
    if (updatedUser == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
  	User user = userService.findById(id);
    userService.delete(user);
  }
}
