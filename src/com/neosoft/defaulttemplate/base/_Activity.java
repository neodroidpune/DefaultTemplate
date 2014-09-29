package com.neosoft.defaulttemplate.base;

import com.neosoft.defaulttemplate.utils.Values;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

public class _Activity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	public void smallToast(Object msg) {

		Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show();
	}

	public void vLog(Object msg) {

		Log.v(Values.LOG_TAG, msg.toString());
	}
	
	public void eLog(Object msg) {

		Log.e(Values.LOG_TAG, msg.toString());
	}
}
