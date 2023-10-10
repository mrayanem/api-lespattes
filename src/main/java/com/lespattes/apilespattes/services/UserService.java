package com.lespattes.apilespattes.services;

import com.lespattes.apilespattes.domain.User;
import com.lespattes.apilespattes.dtos.UserDTO;
import com.lespattes.apilespattes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return this.repository.findAll();
    }

    public User findUserById(String id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public void saveUser(User user) { this.repository.save(user); }
}
