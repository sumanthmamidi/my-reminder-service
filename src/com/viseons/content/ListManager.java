package com.viseons.content;

public class ListManager {
	
	UserList userlist;
	private static ListManager listmngr;
	
	
	public static ListManager getInstance(){
		if(listmngr==null){
			listmngr = new ListManager();
		}
		return listmngr;
	}
	
	public UserList getUserList(){
		
		if(userlist==null){
			userlist = new UserList();
			
			IListItem item = new ListItem("milk");
			userlist.add(item);
		}
		
		return userlist;
	}
	

	public void addToUserList(IListItem item){
		userlist.add(item);
	}
}
