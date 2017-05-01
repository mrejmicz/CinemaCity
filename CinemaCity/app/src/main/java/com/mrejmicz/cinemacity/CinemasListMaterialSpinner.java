package com.mrejmicz.cinemacity;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mklimek.frameviedoview.FrameVideoView;

public class CinemasListMaterialSpinner extends AppCompatActivity {

    MaterialSpinner cinemasSpinnerList;
    MaterialSpinner daySpinnerList;
    ListView filmsListView;
    String connectURL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cinemas_list_material_spinner);

        cinemasSpinnerList = (MaterialSpinner) findViewById(R.id.cinemaList2);
        filmsListView = (ListView) findViewById(R.id.listView2);
        daySpinnerList = (MaterialSpinner) findViewById(R.id.dayList2);


        String uriString = "android.resource://com.mrejmicz.cinemacity/" + R.raw.ring;
        final String[] cinemasListAll = getResources().getStringArray(R.array.cinemas);
        final String[] stringsURL = getResources().getStringArray(R.array.cinema_repertoire_URL);
        final String daysExtendsURI = "?day=";


        final FrameVideoView frameVideoView = (FrameVideoView) findViewById(R.id.frame_video_view3);
        frameVideoView.setup(Uri.parse(uriString), Color.WHITE);

        frameVideoView.setVisibility(View.INVISIBLE);
        cinemasSpinnerList.setVisibility(View.VISIBLE);
        daySpinnerList.setVisibility(View.INVISIBLE);

        cinemasSpinnerList.setItems(cinemasListAll);
        daySpinnerList.setItems("Dzisiaj", "Jutro", "Pojutrze");

        cinemasSpinnerList.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {

                final int positionParent = position;

                if (position != 0) {
                    connectURL = stringsURL[position - 1];
                    daySpinnerList.setVisibility(View.VISIBLE);
                    frameVideoView.onResume();
                    frameVideoView.setVisibility(View.VISIBLE);
                    filmsListView.setVisibility(View.INVISIBLE);
                    new Connect(filmsListView, connectURL, frameVideoView, getApplicationContext()).execute();

                    daySpinnerList.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                            connectURL = stringsURL[positionParent - 1] + daysExtendsURI + position;
                            frameVideoView.onResume();
                            frameVideoView.setVisibility(View.VISIBLE);
                            filmsListView.setVisibility(View.INVISIBLE);
                            new Connect(filmsListView, connectURL, frameVideoView, getApplicationContext()).execute();
                        }
                    });
                } else {
                    filmsListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.films_list_item, new String[]{getResources().getString(R.string.non_cinema_selected)}));
                    daySpinnerList.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
