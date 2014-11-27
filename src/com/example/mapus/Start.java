package com.example.mapus;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends Activity {
	private TextView DispName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.start);
		getActionBar().hide();
		
		String Result = getIntent().getStringExtra("the_result");
		DispName = (TextView)findViewById(R.id.dispnametextview);
		DispName.setText(Result);
		
		
		ImageView settingsbtn = (ImageView) findViewById(R.id.settingsbutton);
		ImageView mapsbtn = (ImageView) findViewById(R.id.mapsbutton);
		ImageView contactsbtn = (ImageView) findViewById(R.id.contactsbutton);
		ImageView checkoutbtn = (ImageView) findViewById(R.id.checkoutbutton);
		
		settingsbtn.setOnClickListener(new View.OnClickListener() {	
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.mapus.SETTINGS"));	
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
