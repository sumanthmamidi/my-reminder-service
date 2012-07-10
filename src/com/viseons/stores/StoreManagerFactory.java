package com.viseons.stores;

import com.viseons.content.google.GooglePlaces;

public class StoreManagerFactory {

	private static StoreManagerFactory mngrfactory;
	
	public static StoreManagerFactory getInstance(){
		if(mngrfactory==null){
			mngrfactory = new StoreManagerFactory();
		}
		return mngrfactory;
	}
	
	public IStoreManager getStoreManager(){
		return new GooglePlaces();
	}
}
