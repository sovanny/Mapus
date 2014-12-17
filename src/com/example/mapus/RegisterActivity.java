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

public class RegisterActivity extends AsyncTask<String,Void,String> {

   private TextView roleField;
   private Context context;
   //flag 0 means get and 1 means post.(By default it is get.)
   public RegisterActivity(Context context,TextView roleField,int flag) {
      this.context = context;
      //this.statusField = statusField;
      this.roleField = roleField;
   }

   protected void onPreExecute(){

   }
   @Override
   protected String doInBackground(String... arg0) {
      
         try{
        	
        	String studentID = (String)arg0[0];
        	String username = (String)arg0[1];
        	String password = (String)arg0[2];
        	
        	SigninActivity.Displayname = username;
        	SigninActivity.Password = password;
        	SigninActivity.StudentID = studentID;
        	
            String link ="http://sermon.se/koma/add2.php";
            
            //DATA FROM USER INPUT
            String data  = URLEncoder.encode("studentID", "UTF-8") 
            + "=" + URLEncoder.encode(studentID, "UTF-8");
            data += "&" + URLEncoder.encode("username", "UTF-8") 
            + "=" + URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") 
            + "=" + URLEncoder.encode(password, "UTF-8");
            
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
	   
	   this.roleField.setText("");
 	  Intent intent = new Intent("com.example.mapus.START");
 	  intent.putExtra("the_result", result);
 	  context.startActivity(intent);
	   context.startActivity(new Intent("com.example.mapus.START"));
      
	   Toast.makeText(
               context.getApplicationContext(),
                "Successfully created new account!",Toast.LENGTH_SHORT)
               .show();
	   Toast.makeText(
               context.getApplicationContext(),
                "Welcome " + SigninActivity.Displayname + "!" ,Toast.LENGTH_SHORT)
               .show();
	   
	   
      this.roleField.setText(result);
      //this.roleField.setText(result);
   }
}