package com.example.ecosystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calendrier(View view){
        startActivity(new Intent(this,calendrier.class));
    }
    public void localisation(View view){ startActivity(new Intent(this,localisation.class));}
    public void recherche(View view){
        startActivity(new Intent(this,recherche.class));
    }
    public void logocentral(View view){startActivity(new Intent(this,logocentral.class));
    }
}
