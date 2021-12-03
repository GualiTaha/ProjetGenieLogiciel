package com.ESNLEADER.api;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ESNLEADER.model.Role;
import com.ESNLEADER.model.User;
import com.ESNLEADER.repositories.RoleRepository;
import com.ESNLEADER.repositories.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private BCryptPasswordEncoder b;
	
	@GetMapping("/users")
	 List<User> getAll() {
			 return userRepository.findAll();
		  }
	
	@PostMapping("/Inscription")
	User add(@RequestBody User user) {
			 User existUser = userRepository.findByUsername(user.getUsername());
			 if(existUser != null) {
				 return null;
			 }else{
				 System.out.println(user.toString());
				 user.setPassword(passwordEncoder.encode(user.getPassword()));
//				 On donne role par defaux chef de projet
				 Role role = roleRepo.findById((long) 2).orElseThrow();
				 Set<Role> roles = new HashSet<Role>();
				 roles.add(role);
				 user.setRoles(roles);
				 userRepository.save(user);
				 return user;
			 }
	 }

	@PostMapping("/Connexion")
	User signin(@RequestBody User user) {		 
			 User existUser = userRepository.findByUsername(user.getUsername());
			 if(existUser != null) {
				 boolean isMatches = b.matches(user.getPassword(), existUser.getPassword());
				 return isMatches ? existUser : null; 
				
			 } else {
				return null;
			 }		 
	 }

	
	@PutMapping("/user")
	User update(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
	@DeleteMapping("/user/{id}")
	void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}
