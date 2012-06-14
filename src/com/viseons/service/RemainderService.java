package com.viseons.service;

import com.viseons.listener.UserLocationListener;

import android.app.Service;
import android.content.Intent;
import android.location.LocationManager;
import android.os.IBinder;

public class RemainderService extends Service{

	public static final String LOCATION_SERVICE_HANDLE = "location_check";
	public static final int LOCATION_SERVICE_MINTIME = 60000;
	public static final int LOCATION_SERVICE_MINDISTANCE = 1;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("Hurray!!!!!!!!! My Service got started");
		
		LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		if(lm!=null){
			boolean hasNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			if(hasNetwork){
				lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, LOCATION_SERVICE_MINTIME, LOCATION_SERVICE_MINDISTANCE, new UserLocationListener(this));
			}
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		return super.onStartCommand(intent, flags, startId);
	}

}
