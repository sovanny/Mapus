package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Contacts extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);		//action bar back button
        getActionBar().setDisplayShowHomeEnabled(false);	//hide app icon in action bar
		
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
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu items for use in the action bar
      MenuInflater inflater = getMenuInflater();
   
      inflater.inflate(R.menu.second, menu);
      return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
          NavUtils.navigateUpFromSameTask(this);
          return true;
        case R.id.action_direct_settings:		//SETTINGS-KNAPPEN
        	Log.d("MapLog", "Hejhej");
        	startActivity(new Intent("com.example.mapus.SETTINGS"));
        	break;
        	
      }
   
      return super.onOptionsItemSelected(item);
    }
}
