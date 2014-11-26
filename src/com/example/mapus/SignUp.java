package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends Activity{
	
	private EditText id_signupField, username_signupField, 
	password_signupField, passwordConfirm_signupField;
	
	private TextView role;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		getActionBar().hide();
		
		id_signupField = (EditText)findViewById(R.id.id_edit);
		username_signupField = (EditText)findViewById(R.id.username_edit);
		password_signupField = (EditText)findViewById(R.id.password_edit);
		passwordConfirm_signupField = (EditText)findViewById(R.id.password_confirm_edit);
		
		role = (TextView)findViewById(R.id.username);
		
		//BUTTON TO CREATE USER
		Button createbtn = (Button) findViewById(R.id.createuserbutton);
		createbtn.setOnClickListener(new View.OnClickListener() {
			
		
		@Override
		public void onClick(View v) {
			
			createPost(v);
			
			//startActivity(new Intent("com.example.mapus.START"));	
			}
		});
	}
	
	public void createPost(View view){
      
	      	String id = id_signupField.getText().toString();
			String username = username_signupField.getText().toString();
			String password = password_signupField.getText().toString();
			String passwordConfirm = passwordConfirm_signupField.getText().toString();
			
	      //role.setText("Loading...");
			if(id.equals("") || username.equals("") || 
					password.equals("") || passwordConfirm.equals("")){
				
				Toast.makeText(
			               getApplicationContext(),
			                "Please fill all fields!",Toast.LENGTH_SHORT)
			               .show();
			}
			
			else if(!password.equals(passwordConfirm)){
				Toast.makeText(
			               getApplicationContext(),
			                "Different passwords!",Toast.LENGTH_SHORT)
			               .show();
			}
			
			else{
				new RegisterActivity(this,role,1).execute(id,username,password);
			}
	      
	   }
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	

}
