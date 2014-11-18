package com.mrk.htd.jsf.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.rest.HashtagClient;
import com.mrk.htd.sdk.rest.exceptions.NoResultFoundException;
import com.mrk.htd.sdk.rest.exceptions.RestException;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(String hashtag) throws UsernameNotFoundException {
		try {
			Map<String, String> filters = new HashMap<String, String>();
			filters.put("hashtag", hashtag);
			Hashtag hashtagObject = new HashtagClient().findSingle(filters);
			return toUser(hashtagObject);
		} catch (NoResultFoundException e) {
			throw new UsernameNotFoundException("hashtag for name \"" + hashtag + "\" not found.");
		} catch (RestException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}

	}

	private UserDetails toUser(final Hashtag hashtagObject) {
		UserDetails details = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				return true;
			}
			
			@Override
			public String getUsername() {
				return hashtagObject.getHashtag();
			}
			
			@Override
			public String getPassword() {
				return hashtagObject.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				Collection<GrantedAuthority> adminAuthorities = new ArrayList<GrantedAuthority>();
				adminAuthorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
				return adminAuthorities;
			}
		};
		return details;
	}

}
