package com.mrk.htd.jsf.security.impl;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mrk.htd.jsf.security.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager; 

	@Override
	public boolean login(String username, String password) throws AuthenticationException{
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		if (authenticate.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			return true;
		}
		return false;
	}

	@Override
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}

}
