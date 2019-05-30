package com.example.ecosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;


public class calendrier extends AppCompatActivity {

    CalendarView calendarView;
    TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendrier);

        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.imageButton);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateDisplay = (TextView) findViewById(R.id.date_display);
        dateDisplay.setText("Date: ");


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                if ((i2 == 2) || (i2 == 9) || (i2 == 16) || (i2 == 23) || (i2 == 30) && i1 == 4){
                    dateDisplay.setText("Date: " + i2 + " / " + (i1+1) + " / " + i + "\n\n" + "C'est le jour de la collecte des poubelles jaunes : emballages, journaux, magazines.");
                }
                else if ((i2 == 4) || (i2 == 7) ||(i2 == 11) || (i2 == 14) || (i2 == 18) || (i2 == 21) || (i2 == 25) || (i2 == 28) && i1 == 4){
                    dateDisplay.setText("Date: " + i2 + " / " + (i1+1) + " / " + i + "\n\n" + "C'est le jour de la collecte des poubelles marrons : ordures mÃ©nagÃ¨res.");
                }
                else{
                    dateDisplay.setText("Date: " + i2 + " / " + (i1+1) + " / " + i + "\n\n" + "Il n'y a aucune collecte aujourd'hui.");
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
                            break;
                        case R.id.imageButton2:
                            Intent produit2 = new Intent(calendrier.this, localisation.class);
                            startActivity(produit2);
                            break;
                        case R.id.imageButton3:
                            Intent produit3 = new Intent(calendrier.this, MainActivity.class);
                            startActivity(produit3);
                            break;
                        case R.id.imageButton4:
                            Intent produit4 = new Intent(calendrier.this, recherche.class);
                            startActivity(produit4);
                            break;
                        case R.id.imageButton5:
                            Intent produit5 = new Intent(calendrier.this, logocentral.class);
                            startActivity(produit5);;
                            break;
                    }

                    return true;
                }
            };
}