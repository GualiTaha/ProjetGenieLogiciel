package com.ESNLEADER.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ESNLEADER.model.Role;
import com.ESNLEADER.repositories.RoleRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/role" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {
	@Autowired
	RoleRepository roleRepo;
	
	@GetMapping("/lister")
	 List<Role> getAll() {
			 return roleRepo.findAll();
		  }
}
