package com.ESNLEADER.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ESNLEADER.model.Role;
import com.ESNLEADER.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 2430560425656187939L;
		private Long id;
		private String username;
		@JsonIgnore
		private String password;
		private Collection<? extends GrantedAuthority> authorities;


		public UserDetailsImpl(Long id,String username, String password,
				Collection<? extends GrantedAuthority> authorities) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.authorities = authorities;
		}

		public static UserDetailsImpl build(User user) { 
			System.out.println("enter 2");
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			Set<Role> roles = user.getRoles();
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
			
//			List<GrantedAuthority> authorities = null;
			System.err.println("enter to UserDetailsImp");

			return new UserDetailsImpl(
					user.getId(), 
					user.getUsername(),
					user.getPassword(), 
					authorities);
			
		}
		
		

		

		public Long getId() {
			return id;
		}

		@Override
		public String getPassword() {
			return password;
		}


		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			UserDetailsImpl user = (UserDetailsImpl) o;
			return Objects.equals(id, user.id);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			return authorities;
		}
		
		

		@Override
		public String getUsername() {
			return username;
		}
}
