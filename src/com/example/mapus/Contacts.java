package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contacts extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		
		Button settingsbtn = (Button) findViewById(R.id.settingsbutton);
		Button addbtn = (Button) findViewById(R.id.addcontactbutton);
		
		settingsbtn.setOnClickListener(new View.OnClickListener() {	
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.mapus.MENUONE"));	
			}
		});
		
		addbtn.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				startActivity(new Intent("com.example.mapus.MENUONE"));	
				}
			});
	}
}
