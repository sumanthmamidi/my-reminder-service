package com.viseons;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RemainderServiceActivity extends Activity {
    /** Called when the activity is first created. */
	
	BroadcastReceiver locationBroadcast = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			TextView coords = (TextView)findViewById(R.id.main_coords);
			Bundle location_details = intent.getExtras();
			String location_lat = Double.toString((Double)location_details.get("latitude"));
			String location_long = Double.toString((Double) location_details.get("longitude"));
			
			coords.setText(coords.getText()+"\n"+location_lat+","+location_long);
		}
	};
	
	IntentFilter locationFilter = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn_open_maps= (Button) findViewById(R.id.main_open_maps);
        btn_open_maps.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i_maps = new Intent(RemainderServiceActivity.this, MapsActivity.class);
				startActivity(i_maps);
			}
		}
		);
        
        Button btn_start_service= (Button) findViewById(R.id.main_start_service);
        btn_start_service.setOnClickListener(new ServiceStarter(this));
        
        locationFilter = new IntentFilter("com.viseons.action.LOCATION");
        
    }
    
    @Override
    protected void onResume() {
    	
    	registerReceiver(locationBroadcast, locationFilter);
    	super.onResume();
    }
    
    @Override
    protected void onPause() {
    	
    	unregisterReceiver(locationBroadcast);
    	super.onPause();
    }
    
}