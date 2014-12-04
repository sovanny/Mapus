package com.example.mapus;

import com.qozix.tileview.TileView;
import com.qozix.tileview.TileView.TileViewEventListenerImplementation;
import com.qozix.tileview.markers.MarkerEventListener;
//import com.qozix.tileview.markers.MarkerEventListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MapActivity2 extends Activity{

	TileView tileView;
	ImageView testMarker;
	private int marker_x;
	private int marker_y;

	private TileViewEventListenerImplementation listener = new TileViewEventListenerImplementation(){
        public void onTap( int x, int y ) {
            Log.d( "DEBUG", "tapped" );
            
            //create marker
            testMarker = new ImageView(getBaseContext());
            testMarker.setImageResource(R.drawable.map_marker_blue);
            testMarker.setTag("Test3");
            tileView.addMarker(testMarker, x, y);
        }
    };
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create our TileView
        tileView = new TileView(this);

        // Set the minimum parameters
        tileView.setSize(2550,1970);
        tileView.addDetailLevel(1f, "tiles/tp5/1000/%col%_%row%.png", "samples/tp5-500.png");
        tileView.addDetailLevel(0.5f, "tiles/tp5/500/%col%_%row%.png", "samples/tp5-500.png");
        //tileView.addDetailLevel(0.25f, "tiles/tp5/250/%col%_%row%.png", "samples/tp5-500.png");
        //tileView.addDetailLevel(0.125f, "tiles/tp5/125/%col%_%row%.png", "samples/tp5-500.png");

        //marker test
        ImageView markerA = new ImageView(this);
        markerA.setImageResource(R.drawable.map_marker_blue);
        markerA.setTag("Test1");

        ImageView markerB = new ImageView(this);
        markerB.setImageResource(R.drawable.map_marker_blue);
        markerB.setTag("Test2");

        tileView.addMarker(markerA, 300, 300);
        tileView.addMarker(markerB, 300, 500);
        
        //marker listener
        tileView.addMarkerEventListener(new MarkerEventListener(){
        	  @Override
        	  public void onMarkerTap( View view, int x, int y ){
        		  
        		  setCoord(x, y);
					
        		  Log.d("Marker Event", "marker tag = " + view.getTag() + ", coordinates (X:Y) = " + x + ":" + y );
					
        		  // create a simple callout
        		  MapusCallout callout = new MapusCallout( view.getContext() );
        		  // add it to the view tree at the same position and offset as the marker that invoked it
        		  tileView.addCallout( callout, x, y, -0.5f, -1.0f );
        		  // a little sugar
        		  callout.transitionIn();
        	    
        	  }
        	});
        
        tileView.addTileViewEventListener( listener );
        	
        
        // use pixel coordinates to roughly center it
        // they are calculated against the "full" size of the mapView 
        // i.e., the largest zoom level as it would be rendered at a scale of 1.0f
        //tileView.moveToAndCenter(1275,1970);
        //tileView.slideToAndCenter(900,500);

        // Set the default zoom (zoom out by 4 => 1/4 = 0.25)
         tileView.setScale( 0.5 );
        
        
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
	
	public void setCoord(int x, int y){
		marker_x = x;
		marker_y = y;
	}
	
	public int getCoordX(){
		return marker_x;
	}
	
	public int getCoordY(){
		return marker_y;
	}
    
}
