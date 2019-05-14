package com.example.ecosystem;

import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class produit extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    private String selectedName;
    private int selectedID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produit);
        mDatabaseHelper = new DatabaseHelper(this);


        //get the intent extra from the recherche
        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("ID", -1); //NOTE: -1 is just the default value
        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("Name");

        TextView textView = (TextView) findViewById(R.id.Text1);
        textView.setText("Produit : " + selectedName); //set text for text view


        Cursor data = mDatabaseHelper.getPoubelle(selectedID);
        String Poubelle = "";
        while (data.moveToNext()) {
            Poubelle = data.getString(0);
        }
        textView = (TextView) findViewById(R.id.Text2);
        textView.setText("Poubelle : " + Poubelle); //set text for text view


        Cursor data2 = mDatabaseHelper.getDescription(selectedID);
        String Description = "";
        while (data2.moveToNext()) {
            Description = data2.getString(0);
        }
        textView = (TextView) findViewById(R.id.Text3);
        textView.setText("Description : " + Description); //set text for text view

    }
}
