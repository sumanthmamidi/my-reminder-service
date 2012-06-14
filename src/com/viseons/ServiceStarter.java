package com.viseons;

import android.content.Context;
import android.location.LocationManager;
import android.view.View;
import android.view.View.OnClickListener;

import com.viseons.listener.UserLocationListener;

public class ServiceStarter implements OnClickListener{
	
	public static final String LOCATION_SERVICE_HANDLE = "location_check";
	public static final int LOCATION_SERVICE_MINTIME = 60000;
	public static final int LOCATION_SERVICE_MINDISTANCE = 1;

	Context context;
	public ServiceStarter(Context context){
		this.context = context;
	}
	
	@Override
	public void onClick(View v) {
		LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
		
		if(lm!=null){
			boolean hasNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			if(hasNetwork){
				lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, LOCATION_SERVICE_MINTIME, LOCATION_SERVICE_MINDISTANCE, new UserLocationListener(context));
			}
		}
		
	}

}
