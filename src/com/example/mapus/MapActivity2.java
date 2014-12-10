package com.example.mapus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.qozix.tileview.TileView;
import com.qozix.tileview.TileView.TileViewEventListenerImplementation;
import com.qozix.tileview.markers.MarkerEventListener;

public class MapActivity2 extends Activity{

	static TileView tileView;
	static ImageView userMarker;
	static boolean markerIsSet = false;
	MapusCallout callout;
	
	static int xPos;
	static int yPos;

	static Context mContext;
	
	private TileViewEventListenerImplementation listener = new TileViewEventListenerImplementation(){
        public void onTap( int x, int y ) {
//            Log.d( "DEBUG", "scale = " + tileView.getScale() );
            
            //create marker
        	if(!markerIsSet){
	            userMarker = new ImageView(getBaseContext());
	            userMarker.setImageResource(R.drawable.map_marker_blue);
	            userMarker.setTag("Test3");
	            
	            //getScale test
	            if(tileView.getScale() > 0.9){
	            	tileView.addMarker(userMarker, x - 50, y - 135);
	            	
	            	xPos = x - 50;
	            	yPos = y - 135;
	            	
	            	createCallout(userMarker.getContext(), x - 50, y - 135);
	            }
	            
	            else{
	            	//tileView.setScale(1.0);
	            	//tileView.moveToAndCenter(x,y);
	            	tileView.addMarker(userMarker, x + 250, y + 100);
	            	
	            	xPos = x + 250;
	            	yPos = y + 100;
	            	
	            	createCallout(userMarker.getContext(), x + 250, y + 100);
	            }
	            
//	            Log.d("DEBUG", "position set: " + xPos + ":" + yPos);
	            markerIsSet = true;
        	}
        }
    };
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayShowHomeEnabled(false);


        mContext = this;

        //signifier toast
        Toast.makeText(
                this, "Tap to set marker!",Toast.LENGTH_SHORT)
                .show();

        
        // Create our TileView
        tileView = new TileView(this);

        // Set the minimum parameters
        tileView.setSize(2550,1970);
        tileView.addDetailLevel(1f, "tiles/tp5/1000/%col%_%row%.png", "samples/tp5-1000.png");
        tileView.addDetailLevel(0.5f, "tiles/tp5/500/%col%_%row%.png", "samples/tp5-1000.png");
        //tileView.addDetailLevel(0.25f, "tiles/tp5/250/%col%_%row%.png", "samples/tp5-500.png");
        //tileView.addDetailLevel(0.125f, "tiles/tp5/125/%col%_%row%.png", "samples/tp5-500.png");

        //marker test
//        ImageView markerA = new ImageView(this);
//        markerA.setImageResource(R.drawable.map_marker_blue);
//        markerA.setTag("Test1");
//
//        ImageView markerB = new ImageView(this);
//        markerB.setImageResource(R.drawable.map_marker_blue);
//        markerB.setTag("Test2");
//
//        tileView.addMarker(markerA, 300, 300);
//        tileView.addMarker(markerB, 300, 500);
        //tileView.removeMarker(markerB);
        
        //if marker set
//        if(xPos != 0 || yPos != 0){
//        	ImageView markerPrev = new ImageView(this);
//            markerPrev.setImageResource(R.drawable.map_marker_blue);
//            
//            double xPrev = (double)xPos;
//            double yPrev = (double)yPos;
//            
//        	tileView.addMarker(userMarker, xPos, yPos);
//        	Log.d("DEBUG", "position retrieved: " + xPrev + ":" + yPrev);
//        }
        
        
        //marker listener
        tileView.addMarkerEventListener(new MarkerEventListener(){
        	  @Override
        	  public void onMarkerTap( View view, int x, int y ){
        		  tileView.slideToAndCenter( x, y);
					
        		  Log.d("Marker Event", "marker tag = " + view.getTag() + ", coordinates (X:Y) = " + x + ":" + y );
        		  
        		  createCallout(view.getContext(), x, y);
        	    
        	  }
        	});
        
        tileView.addTileViewEventListener( listener );
        
        // use pixel coordinates to roughly center it
        // they are calculated against the "full" size of the mapView 
        // i.e., the largest zoom level as it would be rendered at a scale of 1.0f
        //tileView.moveToAndCenter(1275,1970);
        //tileView.slideToAndCenter(900,500);

        // Set the default zoom (zoom out by 4 => 1/4 = 0.25)
        //tileView.setScale( 0.5 );
        
        
        //You can activate the cache if you are using remote pictures with the following code
        //tileView.setCacheEnabled(true);
        
        // Add the view to display it
        setContentView(tileView);
    }

    
    
	@Override
	public void onPause() {
		super.onPause();
		tileView.clear();
	}

	@Override
	public void onResume() {
		super.onResume();
		tileView.resume();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		tileView.destroy();
		tileView = null;
	}
	
	public TileView getTileView(){
		return tileView;
	}
	
	public void createCallout(Context c, int x, int y){
		  // create a simple callout
		  callout = new MapusCallout(c);
		  callout.setCoord(x, y);

		  // add it to the view tree at the same position and offset as the marker that invoked it
		  tileView.addCallout( callout, x, y, -0.5f, -1.0f);
		  // a little sugar
		  callout.transitionIn();
	}
	
	public static void removeUserMarker(){
		tileView.removeMarker(userMarker);
	}
	
	public static int getPosX(){
		return xPos;
	}
	
	public static int getPosY(){
		return yPos;
	}
	
	public static void sharePosition(){
		mContext.startActivity(new Intent("com.example.mapus.SHAREPOSITION"));
	}

}
