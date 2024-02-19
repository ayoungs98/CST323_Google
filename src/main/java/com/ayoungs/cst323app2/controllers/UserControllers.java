package com.ayoungs.cst323app2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ayoungs.cst323app2.models.User;
import com.ayoungs.cst323app2.repo.UserRepo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserControllers {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	@PostMapping(value = "/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "Saved..";
	}
	
	@PutMapping(value = "update/{id}")
	public String updateUser(@PathVariable long id, @RequestBody User user) {
		User updateUser = userRepo.findById(id).get();
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(user.getPassword());
		updateUser.setEmail(user.getEmail());
		userRepo.save(updateUser);
		return "Updated...";
	}
	
	@DeleteMapping(value ="/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "Deleted user with id: " +id;
		
	}
	

}
