package com.neosoft.defaulttemplate;

import android.content.Intent;
import android.os.Bundle;

import com.neodroidpune.sleeputil.Sleeper;
import com.neodroidpune.sleeputil.Sleeper.SleepListner;
import com.neosoft.defaulttemplate.base._Activity;

public class SplashActivity extends _Activity {

	private static final long SPLASH_TIME = 2000;
	private static final int SPLASH_SLEEP_ID = 1;

	private Intent mainActivityIntent = new Intent(this, MainActivity.class);
	
	private Sleeper sleep = new Sleeper(SPLASH_TIME, new SleepListner() {
		
		@Override
		public void onSleepComplete(int arg0) {
			
			startActivity(mainActivityIntent);
			SplashActivity.this.finish();
		}
	}, SPLASH_SLEEP_ID);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getSupportActionBar().hide();
		
		setContentView(R.layout.activity_splash);
		
		sleep.start();
	}
}