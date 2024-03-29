package com.viseons.listener;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.viseons.MapsActivity;
import com.viseons.RemainderServiceActivity;
import com.viseons.content.ListManager;
import com.viseons.content.StoreList;
import com.viseons.content.UserList;
import com.viseons.stores.IStoreManager;
import com.viseons.stores.StoreManager;
import com.viseons.stores.StoreManagerFactory;

public class UserLocationListener implements LocationListener {

	Context context;
	
	public UserLocationListener(Context context){
		this.context = context;
	}
	@Override
	public void onLocationChanged(Location location) {
		
		if(RemainderServiceActivity.isForeGround){
			Intent i = new Intent("com.viseons.action.LOCATION");
			i.putExtra("latitude", location.getLatitude());
			i.putExtra("longitude", location.getLongitude());
			context.sendBroadcast(i);
		}
		
		else{
			
			ListManager lm = ListManager.getInstance();
			UserList ul = lm.getUserList();
			if(!ul.isEmpty()){
				//getList of Items and search for Stores nearest to location
				IStoreManager sm = StoreManagerFactory.getInstance().getStoreManager();
				StoreList stores = sm.getStores("milk", location);
				
				if(stores!=null && !stores.isEmpty()){
					//Notify user
					NotificationManager nmgr = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
					CharSequence tickerText = "Remainder-Ticker";
					long when = System.currentTimeMillis();
	
					Notification notification = new Notification(R.drawable.stat_notify_sync, tickerText, when);
								
					CharSequence contentTitle = "Remainder";
					CharSequence contentText = "You may want to buy items!" ;
					
					//Show maps activity with the stores located
					Intent notificationIntent = new Intent(context, MapsActivity.class);
					String[] coords = new String[10];
					
					coords[0] = Double.toString(location.getLatitude())+","+Double.toString(location.getLongitude());
					notificationIntent.putExtra("coords", coords);
					PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
	
					notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
					notification.defaults = Notification.DEFAULT_ALL;
					nmgr.notify(1, notification);
				}
			}
		}
			
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

}
