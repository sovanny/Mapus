package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);
		Button createbtn = (Button) findViewById(R.id.createuserbutton);
		createbtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(new Intent("com.example.mapus.START"));	
			}
		});
	}
	

}
