package com.mrejmicz.cinemacity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.mklimek.frameviedoview.FrameVideoView;

public class CinemasList extends AppCompatActivity {

    Spinner cinemasSpinnerList;
    Spinner citiesSpinnerList;
    TextView repertoireTextView;
    int cinemaSelectedID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cinemas_list);

        cinemasSpinnerList = (Spinner) findViewById(R.id.cinemaList);
        citiesSpinnerList = (Spinner) findViewById(R.id.citiesList);
        repertoireTextView = (TextView) findViewById(R.id.repertoireText);

        String uriString = "android.resource://com.mrejmicz.cinemacity/" + R.raw.ring;
        final String[] cinemasListAll = getResources().getStringArray(R.array.cinemas);
        final String[] citiesListString = getResources().getStringArray(R.array.cities);
        final String[] strings = getResources().getStringArray(R.array.cinema_repertoire_URL);

        final FrameVideoView frameVideoView = (FrameVideoView) findViewById(R.id.frame_video_view2);
        frameVideoView.setup(Uri.parse(uriString), Color.WHITE);


        frameVideoView.setVisibility(View.INVISIBLE);
        cinemasSpinnerList.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<String>(this, R.layout.cinemas_spinner_item, citiesListString);


        citiesSpinnerList.setAdapter(citiesAdapter);
        citiesSpinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cinemaSelectedID = (int) id;

                switch ((int) id) {
                    case 0:
                        String[] cinemasAdapterStrings = new String[]{cinemasListAll[0]};
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        cinemasAdapterStrings = new String[]{cinemasListAll[19]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        cinemasAdapterStrings = new String[]{cinemasListAll[20]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        cinemasAdapterStrings = new String[]{cinemasListAll[21]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        cinemasAdapterStrings = new String[]{cinemasListAll[15], cinemasListAll[16]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        cinemasAdapterStrings = new String[]{cinemasListAll[22]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        cinemasAdapterStrings = new String[]{cinemasListAll[23]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        cinemasAdapterStrings = new String[]{cinemasListAll[13], cinemasListAll[14]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        cinemasAdapterStrings = new String[]{cinemasListAll[7], cinemasListAll[8], cinemasListAll[9], cinemasListAll[10]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 9:
                        cinemasAdapterStrings = new String[]{cinemasListAll[24], cinemasListAll[25]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 10:
                        cinemasAdapterStrings = new String[]{cinemasListAll[26]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 11:
                        cinemasAdapterStrings = new String[]{cinemasListAll[11], cinemasListAll[12]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 12:
                        cinemasAdapterStrings = new String[]{cinemasListAll[27]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 13:
                        cinemasAdapterStrings = new String[]{cinemasListAll[28]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 14:
                        cinemasAdapterStrings = new String[]{cinemasListAll[29]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 15:
                        cinemasAdapterStrings = new String[]{cinemasListAll[33]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 16:
                        cinemasAdapterStrings = new String[]{cinemasListAll[17], cinemasListAll[18]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 17:
                        cinemasAdapterStrings = new String[]{cinemasListAll[1], cinemasListAll[2], cinemasListAll[3], cinemasListAll[4], cinemasListAll[5], cinemasListAll[6]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 18:
                        cinemasAdapterStrings = new String[]{cinemasListAll[30]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 19:
                        cinemasAdapterStrings = new String[]{cinemasListAll[31]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                    case 20:
                        cinemasAdapterStrings = new String[]{cinemasListAll[32]};
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.cinemas_spinner_item, cinemasAdapterStrings);
                        cinemasSpinnerList.setAdapter(adapter);
                        cinemasSpinnerList.setVisibility(View.VISIBLE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        cinemasSpinnerList.setAdapter(adapter);
        cinemasSpinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if ((int) id != 0) {

                    frameVideoView.onResume();
                    frameVideoView.setVisibility(View.VISIBLE);
                    repertoireTextView.setText("");

                    new Connect(repertoireTextView, strings[(int) id - 1], frameVideoView).execute();

                } else repertoireTextView.setText("Nie wybrano żadnego kina.");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}