package br.com.sublimoon.pi.repository;

import java.util.Optional;

import br.com.sublimoon.pi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{

    public Optional<User> findByUsername(String login);

}
