package com.example.mapus;

import com.qozix.tileview.TileView;
//import com.qozix.tileview.markers.MarkerEventListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class MapActivity2 extends Activity{

	TileView tileView;

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

     // Add the view to display it
        setContentView(tileView);
        
        ImageView markerA = new ImageView(this);
        markerA.setImageResource(R.drawable.map_marker_blue);
        markerA.setTag("Nice");

        ImageView markerB = new ImageView(this);
        markerB.setImageResource(R.drawable.map_marker_blue);
        markerB.setTag("Paris");

        tileView.addMarker(markerA, 300, 300);
        tileView.addMarker(markerB, 300, 500);
        
        //activate cache?
//        tileView.setCacheEnabled(true);
        
        
    }
    
    
}
