package com.neosoft.defaulttemplate.utils;

import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;

import com.neosoft.defaulttemplate.app.App;

public class Methods {

	public static final boolean isConnected() {
		ConnectivityManager connec = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
		

		if (connec != null) {
			android.net.NetworkInfo wifi = connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			android.net.NetworkInfo mobile = connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if (wifi.isConnected()) {
				return true;
			} else {
				if (mobile != null) {
					if (mobile.isConnected()) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
			
		return false;
	}
	
	public static boolean isPackageExisted(String targetPackage) {
		
        List<ApplicationInfo> packages;
        PackageManager pm = App.getInstance().getPackageManager();
        
        packages = pm.getInstalledApplications(0);
        
        for (ApplicationInfo packageInfo : packages) {
        	
        	if(packageInfo.packageName.equals(targetPackage)) return true;
        }        
        
        return false;
    }
	
	/**
	 * To check if GPS is enabled.
	 * 
	 * @return true if GPS is enabled
	 */
	public static final boolean isGPSEnabled() {
		LocationManager locationManager = (LocationManager) App.getInstance().getSystemService(Context.LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}
	
	/**
	 * To check if device has GPS.
	 * 
	 * @return true if device has GPS
	 */
	public static boolean deviceHasGps() {

        PackageManager packageManager = App.getInstance().getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
    }
}