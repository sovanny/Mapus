package com.example.mapus;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class menu extends Activity{

	private EditText usernameField,passwordField;
	private TextView status,role,method;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usernameField = (EditText)findViewById(R.id.editText1);
        passwordField = (EditText)findViewById(R.id.editText2);
        role = (TextView)findViewById(R.id.textView4);
        
        
		//----------MENU 1---------------------------------------
		Button mn1 = (Button) findViewById(R.id.menu1);
		mn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username = usernameField.getText().toString();
		        String password = passwordField.getText().toString();
		        //method.setText("Get Method");
		        //status.setText(username);
		        loginPost(v);
		        //login(v);
		        
		        
		        /*
		        
		        if(username.equals("Aida") && password.equals("Nordman")){
		        	
		        	//startActivity(new Intent("com.example.mapus.MENUONE"));
		        }else{
		        	Toast.makeText(
	                        getApplicationContext(),
	                         "Wrong Username or Password!",Toast.LENGTH_SHORT)
	                        .show();
		        }
		        */
				
			}
		});
		
		
		
		
		
		
	}
	
	public void login(View view){
	      String username = usernameField.getText().toString();
	      String password = passwordField.getText().toString();
	      method.setText("Get Method");
	      new SigninActivity(this,status,role,0).execute(username,password);

	   }
	   public void loginPost(View view){
	      String username = usernameField.getText().toString();
	      String password = passwordField.getText().toString();
	      method.setText("Post Method");
	      new SigninActivity(this,status,role,1).execute(username,password);
	   }
	
	
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	

}
