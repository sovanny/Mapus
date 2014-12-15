package com.example.mapus;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Mapus.TileViewActivity;
import com.qozix.tileview.TileView;
import com.qozix.tileview.TileView.TileViewEventListenerImplementation;
import com.qozix.tileview.markers.MarkerEventListener;

public class MapActivity2 extends TileViewActivity{

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
//        	Log.d("DEBUG", "koordinater först: " + x + ":" + y);
        	
        	TileView tileView = getTileView();
        	
        	//Relative 0-1 positioning
//            tileView.defineRelativeBounds( 0, 0, 1,  1 );
        	tileView.undefineRelativeBounds();
            
         	//.unscale() instead of manual division         
//            x = (int) ( x / tileView.getScale() );
//            y = (int) ( y / tileView.getScale() );
//            Point point = tileView.translate( x, y );
            
//            x = (int) tileView.unscale(x);
//            y = (int) tileView.unscale(y);
            
            
//            Log.d("DEBUG", "koordinater efter unscale: " + x + ":" + y);
            
//			ImageView markerB = new ImageView(getBaseContext());
//			markerB.setImageResource(R.drawable.map_marker_blue);
//			markerB.setTag("Test2");
//			tileView.addMarker(markerB, 0.7, 0.7);

            //create marker
        	if(!markerIsSet){
	            userMarker = new ImageView(getBaseContext());
	            userMarker.setImageResource(R.drawable.map_marker_blue);
	            userMarker.setTag("Test3");
	            
	            //with relative coord
	            tileView.addMarker(userMarker, x - 50, y - 50);
	            createCallout(userMarker.getContext(), x, y);
	            
	            markerIsSet = true;
	            tileView.defineRelativeBounds( 0, 0, 1,  1 );
        	}
    	}
    };
	
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
        tileView.defineRelativeBounds( 0, 0, 1,  1 );
        
        //marker test
        ImageView markerA = new ImageView(this);
        markerA.setImageResource(R.drawable.map_marker_blue);
        markerA.setTag("Test1");

//        ImageView markerB = new ImageView(this);
//        markerB.setImageResource(R.drawable.map_marker_blue);
//        markerB.setTag("Test2");

        tileView.addMarker(markerA, 0.5, 0.5);
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
        	TileView tileView = getTileView();
        	
        	  @Override
        	  public void onMarkerTap( View view, int x, int y ){
        		  tileView.slideToAndCenter( x, y);
					
        		  Log.d("DEBUG", "marker tag = " + view.getTag() + ", coordinates (X:Y) = " + x + ":" + y );
        		  
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
//        tileView.setScale( 0.5 );
        
        
        //You can activate the cache if you are using remote pictures with the following code
        //tileView.setCacheEnabled(true);
        
        // Add the view to display it
        frameTo(0.5,0.5);
        
        setContentView(tileView);
    }
	
	public void createCallout(Context c, int x, int y){
		TileView tileView = getTileView();
		
		//x,y pixelCoord
		
		  // create a simple callout
		  callout = new MapusCallout(c);
//		  callout.setCoord(x, y);

		  // add it to the view tree at the same position and offset as the marker that invoked it
//		  tileView.addCallout( callout, x, y, -0.5f, -1.0f);
		  tileView.addCallout( callout, x, y);
		  // a little sugar
		  callout.transitionIn();
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
		mContext.startActivity(new Intent("com.example.mapus.SHAREPOSITION"));
	}

}
