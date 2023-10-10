package com.lespattes.apilespattes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lespattes.apilespattes.domain.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository repository;
	@GetMapping
	public ResponseEntity getAllUsers() {
		var response = repository.findAll();
		return ResponseEntity.ok(response);
	}

}
