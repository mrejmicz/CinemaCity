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
    TextView repertoireTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cinemas_list);

        cinemasSpinnerList = (Spinner) findViewById(R.id.cinemaList);
        repertoireTextView = (TextView) findViewById(R.id.repertoireText);
        String uriString = "android.resource://com.mrejmicz.cinemacity/" + R.raw.ring;


        final FrameVideoView frameVideoView = (FrameVideoView) findViewById(R.id.frame_video_view2);
        frameVideoView.setup(Uri.parse(uriString), Color.WHITE);
        frameVideoView.setVisibility(View.INVISIBLE);

        final String[] strings = new String[6];
        strings[0] = "http://www.filmweb.pl/showtimes/Warszawa/Cinema+City+Arkadia-556";
        strings[1] = "http://www.filmweb.pl/showtimes/Warszawa/Cinema+City+Bemowo-199";
        strings[2] = "http://www.filmweb.pl/showtimes/Warszawa/Cinema+City+Janki-175";
        strings[3] = "http://www.filmweb.pl/showtimes/Warszawa/Cinema+City+Mokotów-196";
        strings[4] = "http://www.filmweb.pl/showtimes/Warszawa/Cinema+City+Promenada-144";
        strings[5] = "http://www.filmweb.pl/showtimes/Warszawa/Cinema+City+Sadyba-172";

        String[] cinemasLabels = {"--------------------------------------", "Cinema City Arkadia", "Cinema City Bemowo", "Cinema City Janki", "Cinema City Mokotów", "Cinema City Promenada", "Cinema City Sadyba"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cinemas_spinner_item, cinemasLabels);

        cinemasSpinnerList.setAdapter(adapter);

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
