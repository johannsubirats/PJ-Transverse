package com.example.ecosystem;

import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class produit extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    private String selectedName;
    private int selectedID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produit);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.imageButton3);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        mDatabaseHelper = new DatabaseHelper(this);


        //get the intent extra from the recherche
        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("ID", -1); //NOTE: -1 is just the default value
        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("Name");

        TextView textView = (TextView) findViewById(R.id.Text1);
        textView.setText(selectedName); //set text for text view


        Cursor data = mDatabaseHelper.getPoubelle(selectedID);
        String Poubelle = "";
        while (data.moveToNext()) {
            Poubelle = data.getString(0);
        }
        textView = (TextView) findViewById(R.id.Text2);
        textView.setText(Poubelle); //set text for text view


        Cursor data2 = mDatabaseHelper.getDescription(selectedID);
        String Description = "";
        while (data2.moveToNext()) {
            Description = data2.getString(0);
        }
        textView = (TextView) findViewById(R.id.Text3);
        textView.setText(Description); //set text for text view

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.imageButton:
                            Intent produit = new Intent(produit.this, calendrier.class);
                            startActivity(produit);
                            break;
                        case R.id.imageButton2:
                            Intent produit2 = new Intent(produit.this, localisation.class);
                            startActivity(produit2);
                            break;
                        case R.id.imageButton3:
                            Intent produit3 = new Intent(produit.this, MainActivity.class);
                            startActivity(produit3);
                            break;
                        case R.id.imageButton4:
                            Intent produit4 = new Intent(produit.this, recherche.class);
                            startActivity(produit4);
                            break;
                        case R.id.imageButton5:
                            Intent produit5 = new Intent(produit.this, logocentral.class);
                            startActivity(produit5);;
                            break;
                    }

                    return true;
                }
            };
}
