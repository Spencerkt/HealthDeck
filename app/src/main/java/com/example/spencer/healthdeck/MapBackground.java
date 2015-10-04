package com.example.spencer.healthdeck;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.*;

public class MapBackground extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    ArrayList<Provider>providers = new ArrayList<Provider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_background);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                fillArray();
                setLocations();  // change to setLocations();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    private void fillArray(){
        Provider first = new Provider (37.789535, -122.416106, "Saint Francis Memorial Hospital");
        providers.add(first);
        Provider second = new Provider (37.794520, -122.396816, "Drumm Medical Center");
        providers.add(second);
        Provider third = new Provider (37.769035, -122.433397, "California Pacific Medical Center Davies Campus ");
        providers.add(third);
        Provider fourth = new Provider (37.755434, -122.404316, "San Francisco General Hospital ");
        providers.add(fourth);
        Provider fifth = new Provider (37.782012, -122.441345, "Kaiser Permanente Medical Center ");
        providers.add(fifth);
    }

    private void setLocations() {
        for ( int i = 0; i < providers.size(); i++){
            Provider current = providers.get(i);
            mMap.addMarker(new MarkerOptions().position(new LatLng(current.lat, current.lon)).title(current.companyName));
            mMap.setOnInfoWindowClickListener(this);
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        // is this working???
    }
}


//class Provider {
//
//    String companyName;
//    String docName;
//    String practice;
//    String title;
//    String Address;
//    double lat;
//    double lon;
//
//    public Provider (double lat, double lon, String companyName) {
//        this.lat = lat;
//        this.lon = lon;
//        this.companyName = companyName;
//    }
//
//}