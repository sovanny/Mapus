package com.example.mapus;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends Activity{

	private EditText studentIDField,passwordField;
	private TextView register;
	public static ProgressBar loading_spinner;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
		
		studentIDField = (EditText)findViewById(R.id.username_edit_login);
        passwordField = (EditText)findViewById(R.id.password_edit_login);
        loading_spinner = (ProgressBar)findViewById(R.id.loading);
        
        loading_spinner.setVisibility(View.INVISIBLE);
        
		//BUTTON TO LOG IN
		ImageView signin = (ImageView) findViewById(R.id.sign_in_btn);
		signin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

		        //method.setText("Get Method");
		        //status.setText(username);
		        loginPost(v);
		        //login(v);
			}
		});
		
		
		//LINK TO REGISTER
		ImageView reg = (ImageView) findViewById(R.id.register_btn);
		reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				startActivity(new Intent("com.example.mapus.SIGNUP"));
			}
	
		});
		
		//cheaty shortcut
		TextView cheat = (TextView) findViewById(R.id.logo_icon);
		cheat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				startActivity(new Intent("com.example.mapus.START"));
			}
	
		});
		
	}
	/*
	public void login(View view){
	      String username = usernameField.getText().toString();
	      String password = passwordField.getText().toString();
	      role.setText("Get Method");
	      new SigninActivity(this,role,0).execute(username,password);

	   }*/
	   public void loginPost(View view){
	      String studentID = studentIDField.getText().toString();
	      String password = passwordField.getText().toString();
	      loading_spinner.setVisibility(View.VISIBLE);
	      new SigninActivity(this,1).execute(studentID,password);
	   }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	public static void stopSpin(){
		   loading_spinner.setVisibility(View.INVISIBLE);
	   }
	
	

}
