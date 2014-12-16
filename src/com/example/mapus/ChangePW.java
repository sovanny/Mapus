package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class ChangePW extends Activity{

	private EditText newPassword, confirmPassword, currentPassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepw);
		
		getActionBar().setDisplayShowHomeEnabled(false);
		
		newPassword = (EditText)findViewById(R.id.edit_newPassword);
		currentPassword = (EditText)findViewById(R.id.edit_current_pass_field2);
		confirmPassword = (EditText)findViewById(R.id.edit_confirmPassword2);
		
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
		String newpassword = newPassword.getText().toString();
		String currentpassword = currentPassword.getText().toString();
		String confirmpassword = confirmPassword.getText().toString();
		
		if(currentpassword.equals(SigninActivity.Password))
		{
			if(newpassword.equals(confirmpassword)){
				if(!newpassword.equals("") && !confirmpassword.equals(""))
				{
					new SavePassword(this, 1).execute(newpassword, currentpassword);
				}else{
					Toast.makeText(
			                  getApplicationContext(),
			                   "Fill in new password!",Toast.LENGTH_SHORT)
			                  .show();
				}
				
			}
			else
			{
				Toast.makeText(
		                  getApplicationContext(),
		                   "Different password",Toast.LENGTH_SHORT)
		                  .show();
			}
			
		}
		else
		{
			Toast.makeText(
	                  getApplicationContext(),
	                   "Wrong password",Toast.LENGTH_SHORT)
	                  .show();
		}
		

 	}

}
