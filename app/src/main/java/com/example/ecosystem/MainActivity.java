package com.example.ecosystem;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.imageButton3);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        mDatabaseHelper = new DatabaseHelper(this);

        this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> getname = databaseAccess.getname();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getname);
        this.listView.setAdapter(adapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = (String)adapterView.getItemAtPosition(i);

                Toast toast = Toast.makeText(getApplicationContext(), "You Clicked on : " + name, Toast.LENGTH_SHORT);
                toast.show();

                Cursor data = mDatabaseHelper.getItemID(name); //get the id associated with that name

                int itemID = -1;
                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }
                if(itemID > -1) {
                    Intent produit = new Intent(MainActivity.this, produit.class);
                    produit.putExtra("ID", itemID);
                    produit.putExtra("Name", name);
                    startActivity(produit);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No ID associated with that name", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.imageButton:
                            Intent produit = new Intent(MainActivity.this, calendrier.class);
                            startActivity(produit);
                            break;
                        case R.id.imageButton2:
                            Intent produit2 = new Intent(MainActivity.this, localisation.class);
                            startActivity(produit2);
                            break;
                        case R.id.imageButton3:
                            break;
                        case R.id.imageButton4:
                            Intent produit4 = new Intent(MainActivity.this, recherche.class);
                            startActivity(produit4);
                            break;
                        case R.id.imageButton5:
                            Intent produit5 = new Intent(MainActivity.this, logocentral.class);
                            startActivity(produit5);;
                            break;
                    }

                    return true;
                }
            };
}
