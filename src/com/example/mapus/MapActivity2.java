package com.example.mapus;

import android.content.Context;
import android.content.Intent;
//import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mapus.TileViewActivity;
import com.qozix.tileview.TileView;
import com.qozix.tileview.TileView.TileViewEventListenerImplementation;
import com.qozix.tileview.markers.MarkerEventListener;

public class MapActivity2 extends TileViewActivity{

	static TileView tileView;
	static ImageView userMarker;
	static boolean markerIsSet = false;
	MapusCallout callout;
//	OtherCallout oCallout;
	
	static int xPos;
	static int yPos;

	static Context mContext;
	

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayShowHomeEnabled(false);
        
        //reference the TileView multiple times
     	TileView tileView = getTileView();

        mContext = this;

        //signifier toast
        Toast.makeText(
                this, "Tap to set marker!",Toast.LENGTH_SHORT)
                .show();

        
        // Create our TileView
//        tileView = new TileView(this);

        // Set the minimum parameters
        tileView.setSize(2550,1970);
        tileView.addDetailLevel(1f, "tiles/tp5/1000/%col%_%row%.png", "samples/tp5-1000.png");
        tileView.addDetailLevel(0.5f, "tiles/tp5/500/%col%_%row%.png", "samples/tp5-1000.png");
        //tileView.addDetailLevel(0.25f, "tiles/tp5/250/%col%_%row%.png", "samples/tp5-500.png");
        //tileView.addDetailLevel(0.125f, "tiles/tp5/125/%col%_%row%.png", "samples/tp5-500.png");

        //Relative 0-1 positioning
//        tileView.defineRelativeBounds( 0, 0, 1.0, 1.0 ); 
        
        Log.d("DEBUG", "markerIsSet = " + markerIsSet);
        Log.d("DEBUG", "xPos/yPos = " + xPos + ":" + yPos);
        
        //put marker back in if set before
        if(markerIsSet){        	
        	tileView.removeMarker(userMarker);
        	
        	userMarker = new ImageView(getBaseContext());
            userMarker.setImageResource(R.drawable.map_marker_blue2);
        	tileView.addMarker(userMarker, xPos, yPos, -0.5f, -1.0f);
        }
        
        //static Jakob!
        ImageView jakobMarker = new ImageView(getBaseContext());
        jakobMarker.setImageResource(R.drawable.map_marker_blue);
    	jakobMarker.setTag("jakob");
    	
    	//static Sovanny!
    	ImageView sanniMarker = new ImageView(getBaseContext());
        sanniMarker.setImageResource(R.drawable.map_marker_blue);
        sanniMarker.setTag("sanni");
    	
    	//static berkis!
    	ImageView berkisMarker = new ImageView(getBaseContext());
        berkisMarker.setImageResource(R.drawable.map_marker_blue);
        berkisMarker.setTag("berkis");
    	
    	tileView.addMarker(jakobMarker, 1624, 1697, -0.5f, -1.0f);
    	createOtherCallout(jakobMarker.getContext(), 1624, 1697, "Jakob Andersson");
    	
    	tileView.addMarker(sanniMarker, 1363, 1663, -0.5f, -1.0f);
    	createOtherCallout(sanniMarker.getContext(), 1363, 1663, "Sovanny Huy Nikliklä");
    	
    	tileView.addMarker(berkisMarker, 1071, 780, -0.5f, -1.0f);
    	createOtherCallout(berkisMarker.getContext(), 1071, 780, "Berkant Savas");
        
        //onTap, add marker
    	TileViewEventListenerImplementation listener = new TileViewEventListenerImplementation(){
            public void onTap( int x, int y ) {
//            	Log.d("DEBUG", "koordinater först: " + x + ":" + y);
            	
            	TileView tileView = getTileView();
    
            	//Divides x, y by current scale value, making coordinates correct regardless of zoom level
            	x = (int)tileView.unscale(x);
            	y = (int)tileView.unscale(y);
            	
            	xPos = x;
            	yPos = y;
            	
                Log.d("DEBUG", "koordinater efter unscale: " + x + ":" + y);

                //create marker
            	if(!markerIsSet){
    	            userMarker = new ImageView(getBaseContext());
    	            userMarker.setImageResource(R.drawable.map_marker_blue2);
    	            userMarker.setTag("Test3");
    	            
    	            //with relative coord
    	            tileView.addMarker(userMarker, x, y, -0.5f, -1.0f);
    	            createCallout(userMarker.getContext(), x, y);
    	            
    	            markerIsSet = true;
            	}
        	}
        };
        
        //marker listener
        tileView.addMarkerEventListener(new MarkerEventListener(){
        	TileView tileView = getTileView();
        	
        	  @Override
        	  public void onMarkerTap( View view, int x, int y ){
        		  tileView.slideToAndCenter(x, y);
					
        		  Log.d("DEBUG", "marker tag = " + view.getTag() + ", coordinates (X:Y) = " + x + ":" + y );
        		  
        		  createCallout(view.getContext(), x, y);
        	    
        	  }
        	});
        
        tileView.addTileViewEventListener( listener );
        
        frameTo(1275,985);
        
        setContentView(tileView);
    }
	
	public void createCallout(Context c, int x, int y){
		TileView tileView = getTileView();
		
		// create a simple callout
		callout = new MapusCallout(c);
		//callout.setCoord(x, y);

		// add it to the view tree at the same position and offset as the marker that invoked it
		tileView.addCallout( callout, x, y, -0.5f, -1.4f);
		
		// a little sugar
		callout.transitionIn();
	}
	
	public void createOtherCallout(Context c, int x, int y, String name){
//		Log.d("DEBUG", "debug 2");
		TileView tileView = getTileView();
		
		// create a simple callout
		OtherCallout oCallout = new OtherCallout(c, name);
//		oCallout.setName(name);
//		Log.d("DEBUG", "debug 3");

//		Log.d("DEBUG", "innan add");
		// add it to the view tree at the same position and offset as the marker that invoked it
		tileView.addCallout( oCallout, x, y, -0.5f, -1.8f);
		
//		Log.d("DEBUG", "efter add");
		
		// a little sugar
		oCallout.transitionIn();
//		Log.d("DEBUG", "debug 7");
	}
	public static void removeUserMarker(){
		TileView tileView = getTileView();
		tileView.removeMarker(userMarker);
	}
	
	public static int getPosX(){
		return xPos;
	}
	
	public static int getPosY(){
		return yPos;
	}
	
	public static void sharePosition(){
		Log.d("DEBUG", "sharePos");
		mContext.startActivity(new Intent("com.example.mapus.SHAREPOSITION"));
	}

}
