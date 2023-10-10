package com.lespattes.apilespattes.repositories;

import com.lespattes.apilespattes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserById(String id);
}
