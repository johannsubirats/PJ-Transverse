package com.example.ecosystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.Cursor;
import android.content.Intent;
import android.view.View;




import java.util.List;


public class recherche extends AppCompatActivity {
    private ListView listView;

    DatabaseHelper DatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);

        this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess =     DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> getname = databaseAccess.getname();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getname);
        this.listView.setAdapter(adapter);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();

                Cursor data = DatabaseHelper.getID(name); //get the id associated with that name
                int itemID = -1;
                while (data.moveToNext()) {
                    itemID = data.getInt(0);
                }
                Intent produit = new Intent(recherche.this, produit.class);
                produit.putExtra("ID", itemID);
                produit.putExtra("Name", name);
                startActivity(produit);
            }
        });
    }
}
