package ma.ifootback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ifootback.entities.User;
import ma.ifootback.repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService{

	@Autowired(required=true)
	private UserRepository userRepository;
	
	@Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

	@Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

	@Override
    public User save(User user) {
        return userRepository.save(user);
    }

	@Override
    public void delete(User user) {
    	userRepository.delete(user);
    }
    
	@Override
    public User update(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
          return null;
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setCity(user.getCity());
        existingUser.setCountry(user.getCountry());
        existingUser.setDate_of_birth(user.getDate_of_birth());
        existingUser.setPhone(user.getPhone());
        return userRepository.save(existingUser);
      }
    
	@Override
    public User checkLoginwithemail(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
          return null;
        }
        if (password.equals(user.getPassword())) {
          return user;
        }
        return null;
    }

	@Override
	public List<User> findPlayers() {
		return userRepository.findplayers();
	}
}
