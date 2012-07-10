package com.viseons.stores;

import com.viseons.content.Store;
import com.viseons.content.StoreList;

import android.location.Location;

public class StoreManager {
	StoreList storelist;
	private static StoreManager storemngr;
	
	
	public static StoreManager getInstance(){
		if(storemngr==null){
			storemngr = new StoreManager();
		}
		return storemngr;
	}
	
	public StoreList getStoreListForLocation(Location location){
		
		if(storelist==null){
			storelist = new StoreList();
		}
		
		return storelist;
	}
	

	public void addToUserList(Store store){
		storelist.add(store);
	}
}
