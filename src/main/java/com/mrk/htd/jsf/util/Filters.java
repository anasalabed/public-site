package com.mrk.htd.jsf.util;

import java.util.HashMap;
import java.util.Map;

public class Filters extends HashMap<String, String>{

	public Filters(){
		
	}
	
	public Filters add(String key,String value){
		put(key,value);
		return this;
	}
}
