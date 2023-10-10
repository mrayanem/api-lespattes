package com.lespattes.apilespattes.controllers;

import com.lespattes.apilespattes.domain.User;
import com.lespattes.apilespattes.dtos.UserDTO;
import com.lespattes.apilespattes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lespattes.apilespattes.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		var response = userService.getUsers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity findUserById(@PathVariable String id) throws Exception {
		var response = userService.findUserById(id);
		return ResponseEntity.ok(response);
	}
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
		var newUser = userService.createUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

}
