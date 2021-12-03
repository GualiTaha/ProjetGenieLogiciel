package com.ESNLEADER.converters;

import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.ESNLEADER.dto.UserDto;
import com.ESNLEADER.model.User;

public enum UserDtoToUser implements Function<UserDto, User>{
	INSTANCE;

	@SuppressWarnings("deprecation")
	@Override
	public User apply(UserDto t){
		User p = new User();
				if(p.getId() != null && !StringUtils.isEmpty(p.getId())) {
					p.setUsername(t.getUsername());
					p.setPassword(t.getPassword());
					p.setRoles(t.getRoles());
				}
				return p;
	}
	}