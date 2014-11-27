package com.example.mapus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MenuOne extends Activity{

//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.menu1);
//		
//		//----------MENU 2---------------------------------------
//				Button mn2 = (Button) findViewById(R.id.menu2);
//				mn2.setOnClickListener(new View.OnClickListener() {
//					
//					@Override
//					public void onClick(View v) {
//						// TODO Auto-generated method stub
//						
//						startActivity(new Intent("com.example.mapus.MENUTWO"));
//					}
//				});
//				//--------------------------------------------------------
//	}
//	
	
	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String building;
    String map;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1);
        		
        getActionBar().setDisplayHomeAsUpEnabled(true);		//action bar back button
        getActionBar().setDisplayShowHomeEnabled(false);	//hide app icon in action bar
        
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
        
        
        
        
//     // Listview Group click listener
//        expListView.setOnGroupClickListener(new OnGroupClickListener() {
// 
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v,
//                    int groupPosition, long id) {
//                 Toast.makeText(getApplicationContext(),
//                 "Group Clicked " + listDataHeader.get(groupPosition),
//                 Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
// 
//        // Listview Group expanded listener
//        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
// 
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
// 
//        // Listview Group collasped listener
//        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
// 
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();
// 
//            }
//        });
 
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                        listDataHeader.get(groupPosition)).get(
//                                        childPosition), Toast.LENGTH_SHORT)
//                        .show();
                
                building = listDataHeader.get(groupPosition);
                map = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                
                Toast.makeText(
                        getApplicationContext(),
                         building + ": " + map,Toast.LENGTH_SHORT)
                        .show();
                
                if(groupPosition == 0 && childPosition == 2){
                	startActivity(new Intent("com.example.mapus.MAPACTIVITY"));
                }
                
                
                //startActivity(new Intent("com.example.mapus.MENUTWO"));
                return false;
            }
        });
    }
 
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("T�ppan");
        listDataHeader.add("Spetsen");
        listDataHeader.add("K�ken");
 
        // Adding child data
        List<String> tappan = new ArrayList<String>();
        tappan.add("Plan 3");
        tappan.add("Plan 4");
        tappan.add("Plan 5");
        tappan.add("Plan 6");
        
 
        List<String> spetsen = new ArrayList<String>();
        spetsen.add("Plan 3");
        spetsen.add("Plan 4");
        spetsen.add("Plan 5");
        spetsen.add("Plan 6");
        spetsen.add("Plan 7");
        spetsen.add("Plan 8");

        List<String> kaken = new ArrayList<String>();
        kaken.add("Plan 2");
        kaken.add("Plan 3");
        kaken.add("Plan 4");
        kaken.add("Plan 5");

 
        listDataChild.put(listDataHeader.get(0), tappan); // Header, Child data
        listDataChild.put(listDataHeader.get(1), spetsen);
        listDataChild.put(listDataHeader.get(2), kaken);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu items for use in the action bar
      MenuInflater inflater = getMenuInflater();
   
      inflater.inflate(R.menu.main, menu);
      return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
          NavUtils.navigateUpFromSameTask(this);
          return true;
        case R.id.action_direct_settings:		//SETTINGS-KNAPPEN
        	Log.d("MapLog", "Hejhej");
        	startActivity(new Intent("com.example.mapus.SETTINGS"));
        	break;
        	
      }
   
      return super.onOptionsItemSelected(item);
    }

}
