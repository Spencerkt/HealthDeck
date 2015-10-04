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
    ArrayList<Provider> emergency = new ArrayList<>();
    ArrayList<Provider> family = new ArrayList<>();
    ArrayList<Provider> counselors = new ArrayList<>();
    ArrayList<Provider> all = new ArrayList<>();



    public DataFarm() {
        // needs to trigger all collection maybe...
        emergency.add(new Provider("Harold Fisk", "Emergency Clinic", "711 Van Ness Ave Ste 250", "San Francisco","(415)346-4008", -122.42083, 37.78207));
        emergency.add(new Provider("Kirsten Hsu", "Emergency Clinic", "601 Van Ness Ave Ste 2008","San Francisco","(415)-674-7032", -122.4154, 37.78615));
        emergency.add(new Provider("Marni Warner", "Emergency Clinic", "735 Geary St Apt 502","San Francisco","(510)685-4046", -122.4154, 37.78615));
        emergency.add(new Provider("Evan Raftopoulos", "Emergency Clinic", "136 Guerrero St Apt 203","San Francisco","(415)685-6673", -122.42474, 37.76898));
        emergency.add(new Provider("Mindy Marantz", "Emergency Clinic", "1200 Gough St Ste 700","San Francisco","(510)685-4046", -122.42412, 37.78477));
        emergency.add(new Provider("Holly Bonazera", "Emergency Clinic", "614 Hamilton St","San Francisco","(415)-921-1211", -122.40859, 37.72306));

        family.add(new Provider("Marjan Motallebi",  "Family Practice",  "1282 Market St",  "San Francisco",  "4155521200",  -122.4156,  37.77852));
        family.add(new Provider( "Cheyl Elacio",  "Family Practice",  "1135 Ellis St Apt A301",  "San Francisco",  "4155521200",  -122.42515,  37.78301));
        family.add(new Provider( "Son Le",  "Family Practice",  "735 Larkin St" ,  "San Francisco",  "4156238877",  -122.41791,  37.78477));
        family.add(new Provider( "Sahar Tawfic",  "Family Practice",  "601 Van Ness Ave Ste 2020",  "San Francisco",  "4154414933",  -122.4214,  37.78138));
        family.add(new Provider( "Eugene Mccoy",  "Family Practice",  "1390 Market St Ste 226",  "San Francisco",  "4156215471",  -122.4175,  37.77669));
        family.add(new Provider( "Thomas Moyer",  "Family Practice",  "3874 25th St",  "San Francisco",  "4158243073",  -122.42637,  37.75039));

        counselors.add(new Provider( "Gianni Jones",  "Counselor",  "150 9th St",  "San Francisco",  "4158634582",  -122.41425,  37.77548));
        counselors.add(new Provider( "Julee Kim",  "Counselor",  "433 Turk St",  "San Francisco",  "4159287800",  -122.41652,  37.78238));
        counselors.add(new Provider( "Deanna Mcintyre",  "Counselor",  "433 Turk St",  "San Francisco",  "4159287800",  -122.41652,  37.78238));
        counselors.add(new Provider( "Marilin Price",  "Counselor",  "424 Jones St",  "San Francisco",  "4159287800",  -122.41259,  37.78529));
        counselors.add(new Provider( "Mary Saavedra",  "Counselor",  "614 Capitol St # 3",  "San Francisco",  "4159287800",  -122.2539,  38.10332));
        counselors.add(new Provider( "Suzzane Knudsen",  "Counselor",  "1040 Continentals Way Apt 14",  "San Francisco",  "5095518314",  -122.30458,  37.50967));



        all.add(new Provider("Harold Fisk", "Emergency Clinic", "711 Van Ness Ave Ste 250", "San Francisco","(415)346-4008", -122.42083, 37.78207));
        all.add(new Provider("Kirsten Hsu", "Emergency Clinic", "601 Van Ness Ave Ste 2008","San Francisco","(415)-674-7032", -122.4154, 37.78615));
        all.add(new Provider("Marni Warner", "Emergency Clinic", "735 Geary St Apt 502","San Francisco","(510)685-4046", -122.4154, 37.78615));
        all.add(new Provider("Evan Raftopoulos", "Emergency Clinic", "136 Guerrero St Apt 203","San Francisco","(415)685-6673", -122.42474, 37.76898));
        all.add(new Provider("Mindy Marantz", "Emergency Clinic", "1200 Gough St Ste 700","San Francisco","(510)685-4046", -122.42412, 37.78477));
        all.add(new Provider("Holly Bonazera", "Emergency Clinic", "614 Hamilton St","San Francisco","(415)-921-1211", -122.40859, 37.72306));
        all.add(new Provider("Marjan Motallebi",  "Family Practice",  "1282 Market St",  "San Francisco",  "4155521200",  -122.4156,  37.77852));
        all.add(new Provider( "Cheyl Elacio",  "Family Practice",  "1135 Ellis St Apt A301",  "San Francisco",  "4155521200",  -122.42515,  37.78301));
        all.add(new Provider( "Son Le",  "Family Practice",  "735 Larkin St" ,  "San Francisco",  "4156238877",  -122.41791,  37.78477));
        all.add(new Provider( "Sahar Tawfic",  "Family Practice",  "601 Van Ness Ave Ste 2020",  "San Francisco",  "4154414933",  -122.4214,  37.78138));
        all.add(new Provider( "Eugene Mccoy",  "Family Practice",  "1390 Market St Ste 226",  "San Francisco",  "4156215471",  -122.4175,  37.77669));
        all.add(new Provider( "Thomas Moyer",  "Family Practice",  "3874 25th St",  "San Francisco",  "4158243073",  -122.42637,  37.75039));
        all.add(new Provider( "Gianni Jones",  "Counselor",  "150 9th St",  "San Francisco",  "4158634582",  -122.41425,  37.77548));
        all.add(new Provider( "Julee Kim",  "Counselor",  "433 Turk St",  "San Francisco",  "4159287800",  -122.41652,  37.78238));
        all.add(new Provider( "Deanna Mcintyre",  "Counselor",  "433 Turk St",  "San Francisco",  "4159287800",  -122.41652,  37.78238));
        all.add(new Provider( "Marilin Price",  "Counselor",  "424 Jones St",  "San Francisco",  "4159287800",  -122.41259,  37.78529));
        all.add(new Provider( "Mary Saavedra",  "Counselor",  "614 Capitol St # 3",  "San Francisco",  "4159287800",  -122.2539,  38.10332));
        all.add(new Provider( "Suzzane Knudsen",  "Counselor",  "1040 Continentals Way Apt 14",  "San Francisco",  "5095518314",  -122.30458,  37.50967));

    }


    public ArrayList<Provider> getER(){
        return emergency;
    }

    public ArrayList<Provider> getCounselors(){
        return counselors;
    }

    public ArrayList<Provider> getFamily(){
        return family;
    }

    public ArrayList<Provider> getAll() { return all; }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}


class Provider {

    String companyName,docName,practice,Address,distance,city,ph ;
    double lat,lon;

    public Provider (String docName, String practice, String Address, String city, String ph, double lon, double lat) {

        this.docName = docName;
        this.practice = practice;
        this.Address = Address;
        this.ph = ph;
        this.city = city;
        this.lat = lat;
        this.lon = lon;
    }
}
