package com.mrk.htd.jsf.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.mrk.htd.sdk.beans.Hashtag;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com
 */
public class HashtagDetails implements UserDetails{
	
	private Hashtag hashtag;

	public HashtagDetails(Hashtag hashtag){
		this.hashtag=hashtag;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> adminAuthorities = new ArrayList<GrantedAuthority>();
		adminAuthorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		return adminAuthorities;
	}

	@Override
	public String getPassword() {
		return hashtag.getPassword();
	}

	@Override
	public String getUsername() {
		return hashtag.getHashtag();
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

	/**
	 * 
	 * @return The hashtag
	 */
	public String getHashtag() {
		return hashtag.getHashtag();
	}

	/**
	 * 
	 * @return The createdDate
	 */
	public Date getCreatedDate() {
		return hashtag.getCreatedDate();
	}

	/**
	 * 
	 * @return The ownerFirstName
	 */
	public String getOwnerFirstName() {
		return hashtag.getOwnerFirstName();
	}

	/**
	 * 
	 * @return The ownerLastName
	 */
	public String getOwnerLastName() {
		return hashtag.getOwnerLastName();
	}


}
