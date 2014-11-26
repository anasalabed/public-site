package com.mrk.htd.jsf.security.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.beans.HashtagProfile;
import com.mrk.htd.sdk.rest.Filters;
import com.mrk.htd.sdk.rest.HashtagClient;
import com.mrk.htd.sdk.rest.HashtagProfileClient;
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
			HashtagProfile hashtagProfile = null ;
			
			return new HashtagDetails(hashtagObject);
		} catch (NoResultFoundException e) {
			throw new UsernameNotFoundException("hashtag for name \"" + hashtag + "\" not found.");
		} catch (RestException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}

	}

}
