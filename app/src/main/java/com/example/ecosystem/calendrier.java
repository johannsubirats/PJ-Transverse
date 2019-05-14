package com.example.ecosystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;


public class calendrier extends AppCompatActivity {

    CalendarView calendarView;
    TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendrier);

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
}