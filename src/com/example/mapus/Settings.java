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
	private TextView check;

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
		CurrentPassword = (EditText) findViewById(R.id.edit_current_pass_field);
		
		check = (TextView) findViewById(R.id.pw_check);
		check.setText("");
		
		editDispName.setText(SigninActivity.Displayname);

		// Save button
		ImageView savebtn = (ImageView) findViewById(R.id.save_btn);
		savebtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//Turn all users input into strings 
				String editdispname = editDispName.getText().toString();
				String editpassword = editPassword.getText().toString();
				String editconfirmpassword = editConfirmPassword.getText().toString();
				String currentpassword = CurrentPassword.getText().toString();
	
				if(SigninActivity.getPassword().equals(currentpassword))
				{
					check.setText("");
					if(editpassword.equals(editconfirmpassword) && !editpassword.equals(""))
					{
						savePasswordPost(v);
					}
					
					if(!editpassword.equals(editconfirmpassword)){
						Toast.makeText(
				                  getApplicationContext(),
				                   "Different passwords!",Toast.LENGTH_SHORT)
				                  .show();
					}
					
					else if(!editdispname.equals(""))
					{
						saveDisplaynamePost(v);
					}
					
					
				}else{
					Toast.makeText(
			                  getApplicationContext(),
			                   "Wrong password!",Toast.LENGTH_SHORT)
			                  .show();
					check.setText("-");
					
				}
				
				
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
		String currentpassword_send = CurrentPassword.getText().toString();
		
		new SaveDisplayname(this, 1).execute(username, currentpassword_send);
	}

	public void savePasswordPost(View view) {

		String newpassword = editPassword.getText().toString();
		String currentpassword_send = CurrentPassword.getText().toString();
		
		new SavePassword(this, 1).execute(newpassword, currentpassword_send);
	}

}
