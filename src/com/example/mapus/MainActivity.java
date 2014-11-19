package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText usernameField,passwordField;
	private TextView status,role,method;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        usernameField = (EditText)findViewById(R.id.editText1);
        passwordField = (EditText)findViewById(R.id.editText2);
        //status = (TextView)findViewById(R.id.textView3);
        role = (TextView)findViewById(R.id.textView4);
        //method = (TextView)findViewById(R.id.textView5);
        
		setContentView(R.layout.splash);
        
        Thread logoTimer = new Thread(){
        	public void run(){
        		try{
        			sleep(1000);
        			Intent menuIntent = new Intent("com.example.mapus.WELCOME");
        			startActivity(menuIntent);
        			
        		}catch(InterruptedException e){
        			e.printStackTrace();
        		}

        		finally{
        			finish();
        		}
        		
        	}
        };
        logoTimer.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    

}
