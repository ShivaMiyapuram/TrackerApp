//Worked on developing public users module and implementing them in map including zoom factors.


package com.example.s528748.trackerapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng sydney = new LatLng(40.362552, -94.767392);

        mMap.addMarker(new MarkerOptions().position(sydney).title("Joseph Location"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.362552,-94.767392), 12.0f));

        LatLng publicUser1 = new LatLng(40.332692, -94.870458);
        mMap.addMarker(new MarkerOptions().position(publicUser1).title("David Location"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(publicUser1));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.332692,-94.870458), 12.0f));

        LatLng publicUser2 = new LatLng(40.350650, -94.886080);
        mMap.addMarker(new MarkerOptions().position(publicUser2).title("Alex Location"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(publicUser2));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.350650,-94.886080), 12.0f));

        LatLng publicUser3 = new LatLng(40.357818, -94.890868);
        mMap.addMarker(new MarkerOptions().position(publicUser3).title("Johnson Location"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(publicUser1));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.357818,-94.890868), 12.0f));

        LatLng publicUser4 = new LatLng(40.348272, -94.871527);
        mMap.addMarker(new MarkerOptions().position(publicUser4).title("Mike Location"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(publicUser2));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.348272,-94.871527), 12.0f));
    }
}
