package com.mrejmicz.cinemacity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CinemasList extends AppCompatActivity {


    Spinner cinemasSpinnerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cinemas_list);

        cinemasSpinnerList = (Spinner) findViewById(R.id.cinemaList);

        String[] cinemasLabels = {"Cinema City Arkadia", "Cinema City Bemowo", "Cinema City Janki", "Cinema City Mokotów", "Cinema City Promenada", "Cinema City Sadyba"};
           ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cinemas_spinner_item, cinemasLabels);

        cinemasSpinnerList.setAdapter(adapter);

        cinemasSpinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(CinemasList.this, "Wybrano opcję: " + (id+1), Toast.LENGTH_SHORT).show();

                switch ((int)id){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
