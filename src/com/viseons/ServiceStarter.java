package com.viseons;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import com.viseons.service.RemainderService;

public class ServiceStarter implements OnClickListener{
	
	
	Context context;
	public ServiceStarter(Context context){
		this.context = context;
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(context, RemainderService.class);
		context.startService(i);
	}

}
