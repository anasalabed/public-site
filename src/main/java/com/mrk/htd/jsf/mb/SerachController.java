package com.mrk.htd.jsf.mb;

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
public class SerachController extends AbstractMB<Hashtag> {

	private String query = "";
	private Hashtag serachResults;
	private boolean isAvailable;
	private HashtagProfile hashtagProfile;

	public SerachController() {
	}

	@Override
	protected AbstractRestClient<Hashtag> getResetClient() {
		return new HashtagClient();
	}

	public void find() {
		try {
			serachResults = findSingleWithFilters(new Filters().add("hashtag", query));
			isAvailable = true;
			if(serachResults != null){
				try {
					hashtagProfile = new HashtagProfileClient().findSingle(new Filters().add("hashtagId", getSerachResults().getHashtagId().toString()));
				} catch (RestException e) {
					hashtagProfile = null;
				}	
			}
		} catch (Exception e) {
			isAvailable = false;
		}
	}
	
	public void addFriend(Hashtag hashtag)  {
		if(hashtag == null){
			return;
		}
		HashtagContacts contacts = new HashtagContacts();
		contacts.setContactHashtagId(hashtag);
		contacts.setHashtagId(getHashtagDetails().getHashtagOriginalObject());
		contacts.setAddedDate(new Date());
		try {
			new HashtagContactClient().create(contacts);
			query = "";
			serachResults = null;
			
		} catch (RestException e) {
			JsfUtil.showError(e.getMessage());
		}
		
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Hashtag getSerachResults() {
		return serachResults;
	}
	
	public HashtagProfile getSerachProfile() {
		return hashtagProfile;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	

}
