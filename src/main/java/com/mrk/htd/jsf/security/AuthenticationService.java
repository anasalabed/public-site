package com.mrk.htd.jsf.security;


/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com
 */
public interface AuthenticationService {

	boolean login(String username, String password);

	void logout();
}
