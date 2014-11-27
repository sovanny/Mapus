package com.example.mapus;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchUser extends Activity{

	private EditText studentIDField;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchuser);
		
		studentIDField = (EditText)findViewById(R.id.search_field);
	
		//LINK TO REGISTER
		ImageView search = (ImageView) findViewById(R.id.search_btn);
		search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				searchPost(v);
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
	   public void searchPost(View view){
	      
		   String studentID = studentIDField.getText().toString();
	     
	      new SearchActivity(this,1).execute(studentID);
	   }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	

}
