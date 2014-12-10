package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/*import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;*/

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        getActionBar().hide();
		setContentView(R.layout.splash);
		
		
        Thread logoTimer = new Thread(){
        	public void run(){
        		try{
        			sleep(2000);
        			Intent menuIntent = new Intent("com.example.mapus.MENU");
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

/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	  MenuInflater inflater = getMenuInflater();
	 
	  inflater.inflate(R.menu.main, menu);
	  return super.onCreateOptionsMenu(menu);
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
*/
    

}
