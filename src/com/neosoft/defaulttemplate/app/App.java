package com.neosoft.defaulttemplate.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class App extends Application {

	private static App instance;
	public static String deviceId = null;
	private static SharedPreferences sp;
	
	public static SharedPreferences getS() {

		return sp;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		instance = this;
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	}

	public static final App getInstance() {
		return instance;
	}
}
