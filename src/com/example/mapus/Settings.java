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

	private EditText editDispName, editPassword, editConfirmPassword,
			CurrentPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		getActionBar().setDisplayHomeAsUpEnabled(true); // action bar back
														// button
		getActionBar().setDisplayShowHomeEnabled(false); // hide app icon in
															// action bar

		editDispName = (EditText) findViewById(R.id.edit_disp_name_label);
		editPassword = (EditText) findViewById(R.id.edit_new_pass_field);
		editConfirmPassword = (EditText) findViewById(R.id.edit_conf_pass_field);
		CurrentPassword = (EditText) findViewById(R.id.edit_current_pass_field);

		// Save button
		ImageView savebtn = (ImageView) findViewById(R.id.save_btn);
		savebtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveDisplaynamePost(v);
				savePasswordPost(v);
			}
		});

		// Save button
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

	public void saveDisplaynamePost(View view) {

		// SEND VARIABLES
		String username = editDispName.getText().toString();
		new SaveDisplayname(this, 1).execute(username);
	}

	public void savePasswordPost(View view) {

		String password = editPassword.getText().toString();
		new SavePassword(this, 1).execute(password);
	}

}
