package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		
		Button settingsbtn = (Button) findViewById(R.id.settingsbutton);
		Button mapsbtn = (Button) findViewById(R.id.mapsbutton);
		Button contactsbtn = (Button) findViewById(R.id.contactsbutton);
		Button checkoutbtn = (Button) findViewById(R.id.checkoutbutton);
		
		settingsbtn.setOnClickListener(new View.OnClickListener() {	
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.mapus.MENUONE"));	
			}
		});
		
		mapsbtn.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				startActivity(new Intent("com.example.mapus.MENUONE"));	
				}
			});
		
		contactsbtn.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				startActivity(new Intent("com.example.mapus.CONTACTS"));	
				}
			});
	}
	
	
}
