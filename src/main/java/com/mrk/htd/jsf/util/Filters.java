package com.mrk.htd.jsf.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author mkiswani
 * @site http://www.mkiswani.com
 * @email rhkiswani@gmail.com
 */
public class Filters extends HashMap<String, String>{

	public Filters(){
		
	}
	
	public Filters add(String key,String value){
		put(key,value);
		return this;
	}
}
