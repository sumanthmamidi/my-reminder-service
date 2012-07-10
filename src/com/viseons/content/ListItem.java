package com.viseons.content;

public class ListItem implements IListItem{

	String name;
	
	public ListItem(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
