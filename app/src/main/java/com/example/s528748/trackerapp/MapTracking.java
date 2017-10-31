package com.example.s528748.trackerapp;

import android.icu.text.DecimalFormat;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by S528748 on 10/22/2017.
 */

public class MapTracking extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String email;

    DatabaseReference locations;

    Double lat, lng;

    /**
     * Perform initialization of all fragments and loaders.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_tracking);
        // Obtain the Support Fragment and get notified when the map is ready to be used

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Reference to firebase
        locations = FirebaseDatabase.getInstance().getReference("Locations");

        // Get intent
        if(getIntent()!=null)
        {
            email = getIntent().getStringExtra("email");
            lat = getIntent().getDoubleExtra("lat", 0);
            lng = getIntent().getDoubleExtra("lng", 0);
        }

        if(!TextUtils.isEmpty(email))
            loadLocationForThisUser(email);
    }

    private void loadLocationForThisUser(String email) {

        Query user_location = locations.orderByChild("email").equalTo(email);

        user_location.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapShot: dataSnapshot.getChildren()){
                    Tracking tracking = postSnapShot.getValue(Tracking.class);

                    // Add marker for friend location
                    LatLng friendLocation = new LatLng(Double.parseDouble(tracking.getLat()),
                                                        Double.parseDouble(tracking.getLat()));
                    // create location from user coordinates

                    Location currentUser = new Location("");
                    currentUser.setLatitude(lat);
                    currentUser.setLongitude(lng);


                    // create location from user coordinates
                    Location friend = new Location("");
                    friend.setLatitude(Double.parseDouble(tracking.getLat()));
                    friend.setLongitude(Double.parseDouble(tracking.getLon()));

                    // create function that calculates distance betwwn locations
                    distance(currentUser, friend);

                    // Add friend marker on map

                    mMap.addMarker(new MarkerOptions().position(friendLocation).
                            title(tracking.getEmail()).snippet("Distance " + new DecimalFormat("#.#")
                    .format((distance(currentUser, friend)))).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 12.0f));


                }

                // Create marker for current user
                LatLng current = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(current).title(FirebaseAuth.getInstance().getCurrentUser().getEmail()));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }
        );
    }

    private double distance(Location currentUser, Location friend) {
        double theta = currentUser.getLongitude() - friend.getLongitude();
        double dist = Math.sin(deg2rad(currentUser.getLatitude()))
                        * Math.sin(deg2rad(friend.getLatitude()))
                        * Math.sin(deg2rad(currentUser.getLatitude()))
                        * Math.cos(deg2rad(friend.getLatitude()))
                        * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in SYdney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in SYdney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
