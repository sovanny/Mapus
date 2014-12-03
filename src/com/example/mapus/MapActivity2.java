package com.example.mapus;

import com.qozix.TileViewDemo.SampleCallout;
import com.qozix.tileview.TileView;
import com.qozix.tileview.markers.CalloutManager;
import com.qozix.tileview.markers.MarkerEventListener;
//import com.qozix.tileview.markers.MarkerEventListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MapActivity2 extends Activity{

	TileView tileView;
	protected Object mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create our TileView
        tileView = new TileView(this);

        // Set the minimum parameters
        tileView.setSize(2550,1970);
        tileView.addDetailLevel(1f, "tiles/1000_%col%_%row%.png", "samples/tp5.png");
        tileView.addDetailLevel(0.5f, "tiles/500_%col%_%row%.png", "samples/tp5.png");
        tileView.addDetailLevel(0.25f, "tiles/250_%col%_%row%.png", "samples/tp5.png");
        tileView.addDetailLevel(0.125f, "tiles/125_%col%_%row%.png", "samples/tp5.png");

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
        	    Log.d("Marker Event", "marker tag = " + view.getTag() + ", coordinates (X:Y) = " + x + ":" + y );
//        	    CalloutManager callout = new CalloutManager(mContext, null);
        	    
        	    // create a simple callout
    			SampleCallout callout = new SampleCallout( view.getContext() );
    			// add it to the view tree at the same position and offset as the marker that invoked it
    			tileView.addCallout( callout, x, y, -0.5f, -1.0f );
    			// a little sugar
    			callout.transitionIn();
        	    
        	  }
        	});
        
        // use pixel coordinates to roughly center it
        // they are calculated against the "full" size of the mapView 
        // i.e., the largest zoom level as it would be rendered at a scale of 1.0f
        // tileView.moveToAndCenter(2550,1970);
        // tileView.slideToAndCenter(2550,1970);

        // Set the default zoom (zoom out by 4 => 1/4 = 0.25)
        // tileView.setScale( 0.25 );
        
        
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
    
}
