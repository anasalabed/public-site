package com.mrk.htd.jsf.mb;

import javax.faces.bean.ViewScoped;

import com.mrk.htd.jsf.util.JsfUtil;
import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.rest.AbstractRestClient;
import com.mrk.htd.sdk.rest.Filters;
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
public class HashtagController extends AbstractMB<Hashtag>{

	private String password;
	private boolean isAvailable = true;
	
	@Override
	protected AbstractRestClient<Hashtag> getResetClient() {
		return new HashtagClient();
	}
	
	/**
	 * @return 
	 * 
	 */
	public String submit(){
		if(getSelected() != null && getSelected().getPassword().equals(password)){
			try {
				checkIsAvailable();
				if(!isAvailable){
					JsfUtil.showError("Hashtag is already exist");
					return null;
				}
				create(getSelected());
				return "login.xhtml?faces-redirect=true";
			} catch (RestException e) {
				if(e.getMessage().contains("Duplicate entry")){
					JsfUtil.showError("Hashtag is already exist");
				}else{
					JsfUtil.showError(e.getMessage());
				}
			}
		}else{
			JsfUtil.showError("Passwords should be identical");
		}
		return null;
	}

	/**
	 * 
	 */
	public void checkIsAvailable(){
		if(getSelected() != null && getSelected().getHashtag() != null){
			try {
				Filters filters = new Filters().add("hashtag", getSelected().getHashtag());
				findSingleWithFilters(filters);
				isAvailable = false;
				return;
			}catch(NoResultFoundException e ){
				isAvailable = true;
				return;
			} catch (RestException e) {
				isAvailable = true;
				return;
			}
		}
		isAvailable = true;
	}
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getIsAvailable() {
		return isAvailable;
	}

	/**
	 * 
	 * @param isAvailable
	 */
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	
}
