package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class ChangeDN extends Activity{

	private EditText editDispName, currentPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changedn);
		
		getActionBar().setDisplayShowHomeEnabled(false);
		
		editDispName = (EditText)findViewById(R.id.edit_newDispName);
		currentPassword = (EditText)findViewById(R.id.edit_current_pass_field2);
		
		editDispName.setHint(SigninActivity.Displayname);
		
		ImageView save = (ImageView) findViewById(R.id.save_btn2);
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				saveDisplaynamePost(v);
			}
		});
		
	}
	
	public void saveDisplaynamePost(View view) {
		 
 		// SEND VARIABLES
		String username = editDispName.getText().toString();
		String password = currentPassword.getText().toString();
		if(password.equals(SigninActivity.Password))
		{
			if(!username.equals("")){
				new SaveDisplayname(this, 1).execute(username, password);
			}
			else{
				Toast.makeText(
		                  getApplicationContext(),
		                   "Fill in new username!",Toast.LENGTH_SHORT)
		                  .show();
			}
			
		}
		else{
			Toast.makeText(
	                  getApplicationContext(),
	                   "Wrong password",Toast.LENGTH_SHORT)
	                  .show();
		}
		

 	}

}
