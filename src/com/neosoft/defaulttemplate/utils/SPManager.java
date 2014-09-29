package com.neosoft.defaulttemplate.utils;

import android.content.SharedPreferences;
import android.location.Location;

import com.neosoft.defaulttemplate.app.App;

public class SPManager {

	public static void save(String key, String data) {

		SharedPreferences.Editor editor = App.getS().edit();

		editor.putString(key, data);
		editor.commit();

	}

	public static void saveInt(String key, int data) {

		SharedPreferences.Editor editor = App.getS().edit();

		editor.putInt(key, data);
		editor.commit();

	}

	public static void saveBoolean(String key, boolean data) {

		SharedPreferences.Editor editor = App.getS().edit();

		editor.putBoolean(key, data);
		editor.commit();

	}
	
	public static void saveLocation(String key, Location loc) {

		if (null == loc) {
			
			return;
		}
		
		String data = loc.getLatitude() + "*" + loc.getLongitude();
		
		SharedPreferences.Editor editor = App.getS().edit();

		editor.putString(key, data);
		editor.commit();
	}

	public static void delete(String key) {
		SharedPreferences.Editor editor = App.getS().edit();

		editor.remove(key);
		editor.commit();
	}

	public static String retrive(String key) {
		return App.getS().getString(key, "");
	}

	public static int retriveInt(String key) {
		return App.getS().getInt(key, -1);
	}

	public static boolean retriveBoolean(String key) {
		return App.getS().getBoolean(key, false);
	}

	public static boolean exists(String key) {

		if (App.getS().getString(key, null) == null || App.getS().getString(key, null).equals(null)) {
			return false;
		}

		return true;
	}
}
