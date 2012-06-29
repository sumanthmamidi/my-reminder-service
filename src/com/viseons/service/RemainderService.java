package com.viseons.service;

import android.app.Service;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;

import com.viseons.listener.UserLocationListener;

public class RemainderService extends Service{

	public static final String LOCATION_SERVICE_HANDLE = "location_check";
	public static final int LOCATION_SERVICE_MINTIME = 60000;
	public static final int LOCATION_SERVICE_MINDISTANCE = 1;
	public static LocationListener locationListener;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("Hurray!!!!!!!!! My Service got started");
		
		LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		if(lm!=null){
			boolean hasNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			if(hasNetwork){
				locationListener = new UserLocationListener(this);
				lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, LOCATION_SERVICE_MINTIME, LOCATION_SERVICE_MINDISTANCE, locationListener);
				
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
	@Override
	public void onDestroy() {
		LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
		if(locationListener!=null){
			System.out.println("Unregistering Location updates");
			lm.removeUpdates(locationListener);
		}
		System.out.println("Stopping RemainderService");
		
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
