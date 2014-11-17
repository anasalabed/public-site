package com.mrk.htd.jsf.mb;

import javax.faces.bean.ViewScoped;

import com.mrk.htd.jsf.util.JsfUtil;
import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.rest.AbstractRestClient;
import com.mrk.htd.sdk.rest.HashtagClient;
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

	private String password;
	
	@Override
	protected AbstractRestClient<Hashtag> getResetClient() {
		return new HashtagClient();
	}
	
	public void submit(){
		if(getSelected() != null && getSelected().getPassword().equals(password)){
			try {
				create(getSelected());
				JsfUtil.showSucess("Addedd successfully");
			} catch (RestException e) {
				JsfUtil.showError(e.getMessage());
			}
		}else{
			JsfUtil.showError("Passwords should be identical");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Hashtag getSelected() {
		return super.getSelected();
	}
	
}
