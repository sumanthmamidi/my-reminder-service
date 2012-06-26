package com.viseons;

import java.util.List;

import android.R;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.viseons.maps.MapItemOverlay;


public class MapsActivity extends  MapActivity{

	MapController mc;
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
		
		MapView m = (MapView)findViewById(R.id.mapview);
		mc = m.getController();
		
		Intent inputIntent = getIntent();
		Bundle bundle = inputIntent.getExtras();
		String[] coords = (String[])bundle.get("coords");
		
		List<Overlay> list = m.getOverlays();
		
		Drawable drawable = this.getResources().getDrawable(R.drawable.ic_dialog_map);
		 MapItemOverlay itemizedoverlay = new MapItemOverlay(drawable,this);
		
		for(String coord:coords){
			
			if(coord==null){
				continue;
			}
			String[] coordSplit = coord.split(",");
			int lat =  (int) (Double.parseDouble(coordSplit[0])*1E6);
			int lon = (int) (Double.parseDouble(coordSplit[1])*1E6);
			
			GeoPoint point = new GeoPoint(lat,lon);
			 OverlayItem overlayitem = new OverlayItem(point, "You are here", "I'm in Louisiana!");
			 itemizedoverlay.addOverlay(overlayitem);
			 
			 mc.animateTo(point);
			
		}
		
		list.add(itemizedoverlay);
		
		m.setBuiltInZoomControls(true);
		mc.setZoom(15);
		
	}
}
