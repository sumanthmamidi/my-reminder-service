package com.viseons.content.google;

import org.json.JSONException;
import org.json.JSONObject;

import com.viseons.content.Location;
import com.viseons.content.Store;

public class GoogleStore extends Store {

	JSONObject jsonStore;
	GoogleStore(JSONObject jsonStore){
		this.jsonStore = jsonStore;
	}
	
	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		Location loc;
		try{
			if(jsonStore!=null){
				JSONObject geometry = (JSONObject)jsonStore.get("geometry");
				if(geometry!=null){
					JSONObject location = (JSONObject) jsonStore.get("location");
					if(location!=null){
						 
						String latitude = (String) location.get("lat");
						String longitude = (String) location.get("lng");
						loc = new Location(Double.parseDouble(latitude),Double.parseDouble(longitude));
						return loc;
					}
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getName(){
		String name = "";
		try{
			if(jsonStore!=null){
				name = (String) jsonStore.get("name");
			}
		}catch(JSONException e){
			e.printStackTrace();
		}
		return name;
	}
	
	public String getAddress(){
		String name = "";
		try{
			if(jsonStore!=null){
				name = (String) jsonStore.get("formatted_address");
			}
		}catch(JSONException e){
			e.printStackTrace();
		}
		return name;
	}
}
