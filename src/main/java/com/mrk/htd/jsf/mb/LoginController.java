package com.mrk.htd.jsf.mb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ViewScoped;

import com.mrk.htd.jsf.util.JsfUtil;
import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.rest.AbstractRestClient;
import com.mrk.htd.sdk.rest.HashtagClient;
import com.mrk.htd.sdk.rest.exceptions.NoResultFoundException;
import com.mrk.htd.sdk.rest.exceptions.RestException;

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
	
	public void submit(){
		if(hashtag != null && password != null){
			try {
				Map<String, String> filters = new HashMap<String, String>();
				filters.put("hashtag", hashtag);
				filters.put("password", password);
				Hashtag hashtag = getResetClient().findSingle(filters);
				JsfUtil.showSucess("Addedd successfully" +hashtag);
			} catch (NoResultFoundException e) {
				JsfUtil.showError("Wrong Credentials");
			} catch (RestException e) {
				JsfUtil.showError(e.getMessage());
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
