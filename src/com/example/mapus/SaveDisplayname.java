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

public class SaveDisplayname extends AsyncTask<String, Void, String> {

	private Context context;
	private String username;
	

	// flag 0 means get and 1 means post.(By default it is get.)
	public SaveDisplayname(Context context, int flag) {
		this.context = context;
		// this.statusField = statusField;
	}

	protected void onPreExecute() {

	}

	@Override
	protected String doInBackground(String... arg0) {

		try {
			
			username = (String) arg0[0];
			String currentpassword = (String) arg0[1];
			
			String currentDispName = SigninActivity.Displayname;
			
			String link = "http://sermon.se/koma/saveusername.php";

			String data  = URLEncoder.encode("username", "UTF-8") 
		            + "=" + URLEncoder.encode(username, "UTF-8");
		            data += "&" + URLEncoder.encode("currentDispName", "UTF-8") 
		            + "=" + URLEncoder.encode(currentDispName, "UTF-8");
		            data += "&" + URLEncoder.encode("currentpassword", "UTF-8") 
				            + "=" + URLEncoder.encode(currentpassword, "UTF-8");

			URL url = new URL(link);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			wr.write(data);
			wr.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			// Read Server Response
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				break;
			}
			return sb.toString();
		} catch (Exception e) {
			// return new String("Exception: " + e.getMessage());
			return new String("Check network connection!");
		}
	}

	@Override
	protected void onPostExecute(String result) {
		// this.statusField.setText("Login Successful");

			Toast.makeText(context.getApplicationContext(), "Displayname saved!",
					Toast.LENGTH_SHORT).show();
			
			context.startActivity(new Intent("com.example.mapus.SETTINGS"));
			
			SigninActivity.changeDisplayname(result);
		
			


	}
}