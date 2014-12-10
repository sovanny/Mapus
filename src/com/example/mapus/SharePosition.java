package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SharePosition extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shareposition);
		getActionBar().setDisplayShowHomeEnabled(false);
		
		Button share = (Button) findViewById(R.id.button1);
		share.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				startActivity(new Intent("com.example.mapus.START"));
				Toast.makeText(
		                  getApplicationContext(),
		                   "Your position has been shared.",Toast.LENGTH_SHORT)
		                  .show();
			}
	
		});
		
		Button cancel = (Button) findViewById(R.id.Button01);
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
				
			}
	
		});
	}
	
	
	
}
