package com.mrk.htd.jsf.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.mrk.htd.jsf.security.AuthenticationService;
import com.mrk.htd.jsf.security.impl.HashtagDetails;
import com.mrk.htd.jsf.util.JsfUtil;
import com.mrk.htd.sdk.beans.Hashtag;
import com.mrk.htd.sdk.beans.HashtagContacts;
import com.mrk.htd.sdk.beans.HashtagProfile;
import com.mrk.htd.sdk.rest.AbstractRestClient;
import com.mrk.htd.sdk.rest.Filters;
import com.mrk.htd.sdk.rest.HashtagClient;
import com.mrk.htd.sdk.rest.HashtagContactClient;
import com.mrk.htd.sdk.rest.HashtagProfileClient;
import com.mrk.htd.sdk.rest.exceptions.RestException;
import com.mrk.htd.sdk.util.RestHelper;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com
 */
@javax.faces.bean.ManagedBean
@ViewScoped
public class ContactsController extends AbstractMB<HashtagContacts> {

	private List<HashtagContacts> hashtagContacts = new ArrayList<HashtagContacts>();

	public ContactsController() {
		loadContacts();
	}

	@Override
	protected AbstractRestClient<HashtagContacts> getResetClient() {
		return new HashtagContactClient();
	}

	@Override
	public void delete(int id) throws RestException {
		super.delete(id);
		loadContacts();
	}
	public String loadContacts() {
		try {
			hashtagContacts = findWithFilters(new Filters().add("hashtagId", getHashtagDetails().getHashtagId().toString()));
		} catch (Exception e) {
			JsfUtil.showError(e.getMessage());
		}
		return null;
	}
	
	public String getPictureUrl(int contactId){
		try{
			HashtagProfile profile = new HashtagProfileClient().findSingle(new Filters().add("hashtagId", contactId+""));
			return profile.getProfilePicture();
		}catch(Exception e ){
			return  getUnavailableUrl();
		}
	}

	public List<HashtagContacts> getHashtagContacts() {
		return hashtagContacts;
	}

	public void setHashtagContacts(List<HashtagContacts> hashtagContacts) {
		this.hashtagContacts = hashtagContacts;
	}
	
	public int getHashtagContactsCount(){
		return hashtagContacts.size();
	}
	public void addFriend(Hashtag hashtag)  {
		HashtagContacts contacts = new HashtagContacts();
		contacts.setContactHashtagId(hashtag);
		contacts.setHashtagId(getHashtagDetails().getHashtagOriginalObject());
		contacts.setAddedDate(new Date());
		try {
			super.create(contacts);
		} catch (RestException e) {
			JsfUtil.showError(e.getMessage());
		}
		
	}
}
