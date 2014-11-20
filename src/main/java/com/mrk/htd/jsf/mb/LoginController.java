package com.mrk.htd.jsf.mb;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.mrk.htd.jsf.security.AuthenticationService;
import com.mrk.htd.jsf.security.impl.HashtagDetails;
import com.mrk.htd.jsf.util.JsfUtil;
import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.beans.HashtagProfile;
import com.mrk.htd.sdk.rest.AbstractRestClient;
import com.mrk.htd.sdk.rest.Filters;
import com.mrk.htd.sdk.rest.HashtagClient;
import com.mrk.htd.sdk.rest.HashtagProfileClient;
import com.mrk.htd.sdk.rest.exceptions.RestException;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com
 */
@javax.faces.bean.ManagedBean
@ViewScoped
public class LoginController extends AbstractMB<Hashtag> {

	private String hashtag;
	private String password;

	@Override
	protected AbstractRestClient<Hashtag> getResetClient() {
		return new HashtagClient();
	}

	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService;

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public String submit() {
		if (hashtag != null && password != null) {
			try {

				boolean success = authenticationService.login(this.hashtag, password);
				if (success) {
					return "/secure/index.xhtml?faces-redirect=true";
				} else {
					JsfUtil.showError("Wrong Credentials");
					return null;
				}
			} catch (Exception e) {
				JsfUtil.showError(e.getMessage());
			}
		} else {
			JsfUtil.showError("Username/Passwrod are required");
		}
		return null;
	}

	public String logout() {
		authenticationService.logout();
		return "/login.xhtml?faces-redirect=true";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

}
