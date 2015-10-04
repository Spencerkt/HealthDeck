package com.example.spencer.healthdeck;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.*;

public class MapBackground extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    DataFarm data = new DataFarm();
    ArrayList<Provider> counselors, family, physical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_background);
        fillArrays();
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
                setLocations( getButtonChoice() );  // change to setLocations();
            }
        }
    }

    private void fillArrays(){
        counselors = data.getCounselors();
        family = data.getFamily();
        physical = data.getPT();
    }

    private ArrayList<Provider> getButtonChoice(){
        return family;
    }

    // Not used
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    private void setLocations(ArrayList<Provider> currentData) {
        for ( int i = 0; i < currentData.size(); i++){    // uncomment to run real program.
            Provider current = currentData.get(i);
            mMap.addMarker(new MarkerOptions().position(new LatLng(current.lat, current.lon)).title(current.docName).snippet(current.practice));
            mMap.setOnInfoWindowClickListener(this);
        }
    }

    public void onInfoWindowClick(Marker marker) {
        Intent providerPage = new Intent(this, ProviderInfo.class);
        startActivity(providerPage);
    }

    public void seeProfile(View view) {
        Intent profilePage = new Intent(this, UserMenu.class);
        startActivity(profilePage);
    }

}
