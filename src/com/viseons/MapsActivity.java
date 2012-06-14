package com.viseons;

import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;


public class MapsActivity extends  MapActivity{

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		
		setContentView(R.layout.maps);
		
		MapView map = (MapView) findViewById(R.id.mapview);
		map.setBuiltInZoomControls(true);
		
		
	}
}
