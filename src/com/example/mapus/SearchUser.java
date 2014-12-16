package com.example.mapus;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchUser extends Activity{

	private EditText studentIDField;
	private TextView notfound;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchuser);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);		//action bar back button
        getActionBar().setDisplayShowHomeEnabled(false);	//hide app icon in action bar
		
        studentIDField = (EditText)findViewById(R.id.search_field);
        notfound = (TextView)findViewById(R.id.no_results);
        notfound.setVisibility(View.GONE);
	
		//LINK TO REGISTER
		ImageView search = (ImageView) findViewById(R.id.search_btn);
		search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				//searchPost(v);
				notfound.setVisibility(View.VISIBLE);
				
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
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu items for use in the action bar
      MenuInflater inflater = getMenuInflater();
   
      inflater.inflate(R.menu.main, menu);
      return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
          NavUtils.navigateUpFromSameTask(this);
          return true;
        case R.id.action_direct_settings:		//SETTINGS-KNAPPEN
        	Log.d("MapLog", "Hejhej");
        	startActivity(new Intent("com.example.mapus.SETTINGS"));
        	break;
        	
      }
   
      return super.onOptionsItemSelected(item);
    }

}
