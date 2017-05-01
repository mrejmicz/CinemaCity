package com.mrejmicz.cinemacity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mklimek.frameviedoview.FrameVideoView;

public class CinemasList extends AppCompatActivity {

    Spinner cinemasSpinnerList;
    ListView filmsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cinemas_list);

        cinemasSpinnerList = (Spinner) findViewById(R.id.cinemaList);
        filmsListView = (ListView) findViewById(R.id.listView);

        String uriString = "android.resource://com.mrejmicz.cinemacity/" + R.raw.ring;
        final String[] cinemasListAll = getResources().getStringArray(R.array.cinemas);
        final String[] strings = getResources().getStringArray(R.array.cinema_repertoire_URL);

        final FrameVideoView frameVideoView = (FrameVideoView) findViewById(R.id.frame_video_view2);
        frameVideoView.setup(Uri.parse(uriString), Color.WHITE);

        frameVideoView.setVisibility(View.INVISIBLE);
        cinemasSpinnerList.setVisibility(View.VISIBLE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.cinemas_spinner_item, cinemasListAll);



        cinemasSpinnerList.setAdapter(adapter);
        cinemasSpinnerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if ((int) id != 0) {

                    frameVideoView.onResume();
                    frameVideoView.setVisibility(View.VISIBLE);
                    //repertoireTextView.setText("");
                    filmsListView.setVisibility(View.INVISIBLE);
                    new Connect(filmsListView, strings[(int) id - 1], frameVideoView, getApplicationContext()).execute();

                } else{
                   filmsListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.films_list_item, new String[]{getResources().getString(R.string.non_cinema_selected)}));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}