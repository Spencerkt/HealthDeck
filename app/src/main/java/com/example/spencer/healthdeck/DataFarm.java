package com.example.spencer.healthdeck;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.*;

public class DataFarm extends Service {

    /*
    This class should farm the data from the API, parse it out into the needed data fields,
    and create a 'Provider' object off of each providers profile.  It should then add each
    provider to a list off they type of service they provide.
     */
    ArrayList<Provider>dentist = new ArrayList<Provider>();
    ArrayList<Provider>family = new ArrayList<Provider>();
    ArrayList<Provider>emergency = new ArrayList<Provider>();
    ArrayList<Provider>chiro = new ArrayList<Provider>();
    ArrayList<Provider>physical = new ArrayList<Provider>();

    public DataFarm() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}


class Provider {

    String companyName;
    String docName;
    String practice;
    String title;
    String Address;
    double lat;
    double lon;

    public Provider (double lat, double lon, String companyName) {
        this.lat = lat;
        this.lon = lon;
        this.companyName = companyName;
    }

}
