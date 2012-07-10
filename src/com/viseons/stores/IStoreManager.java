package com.viseons.stores;


import android.location.Location;

import com.viseons.content.StoreList;

public interface IStoreManager {

	public StoreList getStores(String item, Location location);
}
