package com.example.mapus;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Start extends Activity {
	private TextView DispName;
	public static ImageView remove;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.start);
		getActionBar().setDisplayShowHomeEnabled(false);
		
		String Result = getIntent().getStringExtra("the_result");
		
		
		DispName = (TextView)findViewById(R.id.nameTest);
		DispName.setText(SigninActivity.Displayname);
		remove = (ImageView)findViewById(R.id.checkoutbutton);
		//ImageView settingsbtn = (ImageView) findViewById(R.id.settingsbutton);  //gamla knappen i vår hemgjorda actionbar, ska göras i onOptionsItemSelected()
		ImageView mapsbtn = (ImageView) findViewById(R.id.mapsbutton);
		ImageView contactsbtn = (ImageView) findViewById(R.id.contactsbutton);
		ImageView checkoutbtn = (ImageView) findViewById(R.id.checkoutbutton);

		if(SigninActivity.MapSet){
			remove.setBackgroundResource(R.drawable.buttoncircleorange);
		}
		else{
			remove.setBackgroundResource(R.drawable.buttoncircle);
		}
		/*
		settingsbtn.setOnClickListener(new View.OnClickListener() {	
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.mapus.SETTINGS"));	
			}
		});
		*/
		
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
		
		checkoutbtn.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				if(SigninActivity.MapSet)
				{
					Toast.makeText(
			                  getApplicationContext(),
			                   "You have left your position!",Toast.LENGTH_SHORT)
			                  .show();	

					remove.setBackgroundResource(R.drawable.buttoncircle);
					SigninActivity.MapSet = false;
				}
				else{
					Toast.makeText(
			                  getApplicationContext(),
			                   "Position not set!",Toast.LENGTH_SHORT)
			                  .show();	
				}
				
				}
			});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	  MenuInflater inflater = getMenuInflater();
	 
	  inflater.inflate(R.menu.main, menu);
	  return super.onCreateOptionsMenu(menu);
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_direct_settings) {	//settings-knappen vald
        	Log.d("MapLog", "G�r in i settings");
        	startActivity(new Intent("com.example.mapus.SETTINGS"));
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
	
	
}
