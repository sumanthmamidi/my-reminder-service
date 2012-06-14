package com.viseons.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemainderService extends Service{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("Hurray!!!!!!!!! My Service got started");
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
