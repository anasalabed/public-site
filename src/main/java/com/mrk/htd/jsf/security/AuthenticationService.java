package com.mrk.htd.jsf.security;

import javax.annotation.security.RolesAllowed;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com
 */
public interface AuthenticationService {

	boolean login(String username, String password);

	@RolesAllowed({ "ROLE_ADMIN", "ROLE_REGISTERED" })
	void logout();
}
