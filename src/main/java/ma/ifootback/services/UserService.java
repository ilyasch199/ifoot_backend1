package ma.ifootback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ifootback.entities.User;

@Service
public interface UserService {

    public List<User> findAll();
    public User findById(Long id);
    public User save(User user);
    public void delete(User user);
    public User update(User user);
    public User checkLoginwithemail(String email, String password);
    public List<User> findPlayers();
}
