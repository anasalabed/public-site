package com.mrk.htd.jsf.mb;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import com.mrk.htd.sdk.rest.AbstractRestClient;
import com.mrk.htd.sdk.rest.exceptions.RestException;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com 
 */
public abstract class AbstractMB<T> {

	private T selected;
	private Class<?> tClass;

	protected abstract AbstractRestClient<T> getResetClient();

	public AbstractMB() {
		this.tClass = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		initSelected();

	}

	private void initSelected() throws IllegalArgumentException {
		try {
			selected = (T) tClass.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("Failed to create instance from " + tClass.getName() + " Due to :" + e.getMessage());
		}
	}

	public void create(T t) throws RestException {
		 selected = getResetClient().create(t);
	}

	public void delete(int id) throws RestException {
		getResetClient().delete(id);
	}

	public T find(int id) throws RestException {
		return getResetClient().find(id);
	}
	
	public T findSingleWithFilters(Map<String,String> filters) throws RestException {
		return getResetClient().findSingle(filters);
	}
	
	public List<T> findWithFilters(Map<String,String> filters) throws RestException {
		return getResetClient().find(filters);
	}
	
	public List<T> list(int page,int size) throws RestException {
		return getResetClient().list(page,size);
	}
	
	

	public void update(T t) throws RestException {
		selected = getResetClient().update(t);
	}

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	
}
