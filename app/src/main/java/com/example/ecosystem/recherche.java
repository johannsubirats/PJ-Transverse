package com.example.ecosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class recherche extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.imageButton4);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.imageButton:
                            Intent produit = new Intent(recherche.this, calendrier.class);
                            startActivity(produit);
                            break;
                        case R.id.imageButton2:
                            Intent produit2 = new Intent(recherche.this, localisation.class);
                            startActivity(produit2);
                            break;
                        case R.id.imageButton3:
                            Intent produit3 = new Intent(recherche.this, MainActivity.class);
                            startActivity(produit3);
                            break;
                        case R.id.imageButton4:
                            break;
                        case R.id.imageButton5:
                            Intent produit5 = new Intent(recherche.this, logocentral.class);
                            startActivity(produit5);;
                            break;
                    }

                    return true;
                }
            };
}
