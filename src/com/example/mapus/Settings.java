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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Activity {
	
	private TextView studentID_textField, username_textField;
  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		//studentID_textField = (TextView)findViewById(R.id.studentid_text);
		//username_textField = (TextView)findViewById(R.id.username_text);
		
		//studentID_textField.setText(SigninActivity.StudentID);
		//username_textField.setText(SigninActivity.Displayname);

		getActionBar().setDisplayHomeAsUpEnabled(true); // action bar back
														// button
		getActionBar().setDisplayShowHomeEnabled(false); // hide app icon in
															// action bar

		
		
		ImageView pwbtn = (ImageView) findViewById(R.id.change_pw_btn);
		pwbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				startActivity(new Intent("com.example.mapus.CHANGEPW"));
			}
		});
		
		ImageView dnbtn = (ImageView) findViewById(R.id.change_dn_btn);
		dnbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				 
				startActivity(new Intent("com.example.mapus.CHANGEDN"));
			}
		});
		
		
		ImageView logoutbtn = (ImageView) findViewById(R.id.log_out_btn);
		logoutbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				 Toast.makeText(
		                  getApplicationContext(),
		                   "Good Bye!",Toast.LENGTH_SHORT)
		                  .show();
				startActivity(new Intent("com.example.mapus.MENU"));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.settings_activity_bar, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		// Respond to the action bar's Up/Home button
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;

		}

		return super.onOptionsItemSelected(item);
	}



}