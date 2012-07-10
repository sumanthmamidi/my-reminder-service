package com.viseons.content;


public class Store {

	Location location;
	Category category;
	String name;
	String address;
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
}
