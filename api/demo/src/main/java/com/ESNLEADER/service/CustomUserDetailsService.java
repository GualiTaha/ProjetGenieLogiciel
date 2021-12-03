package com.ESNLEADER.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ESNLEADER.model.User;
import com.ESNLEADER.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.err.println("enter loadby");
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User can not be found");
		}
		return UserDetailsImpl.build(user);
	}

}
