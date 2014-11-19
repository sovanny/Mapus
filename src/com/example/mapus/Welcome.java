package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome); 
		
		Button loginbtn = (Button) findViewById(R.id.loginbutton);
		loginbtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.mapus.MENU"));
			
			}
		});
		
		Button signupbtn = (Button) findViewById(R.id.signupbutton);
		signupbtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.mapus.SIGNUP"));
			
			}
		});
	}
	
	
	
}

