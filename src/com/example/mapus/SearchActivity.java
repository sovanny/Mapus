package com.example.mapus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AsyncTask<String,Void,String> {

   private TextView users;
   private Context context;
   //flag 0 means get and 1 means post.(By default it is get.)
   public SearchActivity(Context context,int flag) {
      this.context = context;

   }

   protected void onPreExecute(){

   }
   @Override
   protected String doInBackground(String... arg0) {
      
         try{
        	
        	String studentID = (String)arg0[0];

        	
            String link ="http://sermon.se/koma/add2.php";
            
            //DATA FROM USER INPUT
            String data  = URLEncoder.encode("studentID", "UTF-8") 
            + "=" + URLEncoder.encode(studentID, "UTF-8");

            
            URL url = new URL(link);
            URLConnection conn = url.openConnection(); 
            conn.setDoOutput(true); 
            OutputStreamWriter wr = new OutputStreamWriter
            (conn.getOutputStream()); 
            wr.write( data ); 
            wr.flush(); 
            BufferedReader reader = new BufferedReader
            (new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            // Read Server Response
            while((line = reader.readLine()) != null)
            {
               sb.append(line);
               break;
            }
            return sb.toString();
         }catch(Exception e){
        	 //return new String("Exception: " + e.getMessage());
        	 return new String("Check network connection!");
      }
   }
   @Override
   protected void onPostExecute(String result){
	   //this.statusField.setText("Login Successful");
	   //context.startActivity(new Intent("com.example.mapus.START"));
      
	   Toast.makeText(
               context.getApplicationContext(),
                "User not found!",Toast.LENGTH_SHORT)
               .show();
	   
	   
      this.users.setText(result);
   }
}