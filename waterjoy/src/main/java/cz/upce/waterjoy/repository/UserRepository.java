package cz.upce.waterjoy.repository;

import cz.upce.waterjoy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> { // Vytváří rozhraní UserRepository
    Optional<User> findByUsername(String username);
}
