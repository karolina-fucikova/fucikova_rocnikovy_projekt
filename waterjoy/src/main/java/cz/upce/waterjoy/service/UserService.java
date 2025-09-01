package cz.upce.waterjoy.service;

import cz.upce.waterjoy.model.User;
import cz.upce.waterjoy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importuje třídu na bezpečné hashování hesel
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; // Napojení repozitáře k databázi

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // zašifrování hesla

    public boolean register(String username,String email, String password) {
        System.out.println("Register called with username: " + username + ", email: " + email);
        if (userRepository.findByUsername(username).isPresent()) {
            return false;
        }
        User user = new User(); // nový uživatel
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        userRepository.save(user); // uložení do db
        return true;
    }

    public boolean login(String username, String email, String password) { // přihlášení uživatele
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && encoder.matches(password, user.get().getPassword());
    }

    public boolean deleteUserByUsername(String username) { // mazání uživatele
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return true;
        }
        return false;
    }
}
