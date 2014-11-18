package com.mrk.htd.jsf.mb;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.mrk.htd.jsf.security.AuthenticationService;
import com.mrk.htd.jsf.util.JsfUtil;
import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.rest.AbstractRestClient;
import com.mrk.htd.sdk.rest.HashtagClient;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com 
 */
@javax.faces.bean.ManagedBean
@ViewScoped
public class LoginController extends AbstractMB<Hashtag>{

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
	
	public void submit(){
		if(hashtag != null && password != null){
				boolean success = authenticationService.login(this.hashtag, password);
				if(success){
					JsfUtil.showSucess("Addedd successfully" +hashtag);
				}else{
					JsfUtil.showError("Wrong Credentials");
				}
		}else{
			JsfUtil.showError("Username/Passwrod are required");
		}
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
