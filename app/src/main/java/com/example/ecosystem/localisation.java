package com.example.ecosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class localisation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localisation);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        bottomNavigationView.setSelectedItemId(R.id.imageButton2);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker Villejuif

        LatLng Decheterie= new LatLng(48.817154, 2.354736);
        mMap.addMarker(new MarkerOptions().position(Decheterie).title("Déchétrie").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng Decheterie2= new LatLng(48.815681, 2.389288);
        mMap.addMarker(new MarkerOptions().position(Decheterie2).title("Déchétrie mobile").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng Decheterie3= new LatLng(48.807656, 2.349832);
        mMap.addMarker(new MarkerOptions().position(Decheterie3).title("Déchétrie mobile").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng Decheterie4= new LatLng(48.783170, 2.350832);
        mMap.addMarker(new MarkerOptions().position(Decheterie4).title("Déchétrie mobile").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        LatLng Decheterie5= new LatLng(48.799121, 2.319006);
        mMap.addMarker(new MarkerOptions().position(Decheterie5).title("Déchétrie mobile de Syctom").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng villejuif= new LatLng(48.7932012, 2.3559379);
        mMap.addMarker(new MarkerOptions().position(villejuif).title("Villejuif").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(villejuif,11));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.imageButton:
                            Intent produit = new Intent(localisation.this, calendrier.class);
                            startActivity(produit);
                            break;
                        case R.id.imageButton2:
                            break;
                        case R.id.imageButton3:
                            Intent produit3 = new Intent(localisation.this, MainActivity.class);
                            startActivity(produit3);
                            break;
                        case R.id.imageButton4:
                            Intent produit4 = new Intent(localisation.this, recherche.class);
                            startActivity(produit4);
                            break;
                        case R.id.imageButton5:
                            Intent produit5 = new Intent(localisation.this, logocentral.class);
                            startActivity(produit5);;
                            break;
                    }

                    return true;
                }
            };
}