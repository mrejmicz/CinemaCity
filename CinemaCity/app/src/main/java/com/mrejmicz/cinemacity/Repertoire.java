package com.mrejmicz.cinemacity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Repertoire extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repertoire);

         text = (TextView) findViewById(R.id.text_repertoire);

        String desiredURL1 = "http://www.filmweb.pl/showtimes/Warszawa/Cinema+City+Arkadia-556";
        String desiredURL2 = "http://opinie.wp.pl/mark-leonard-europa-musi-przygotowac-sie-na-najczarniejszy-scenariusz-6114464373155969a";
        String atlantic_cinema = "http://www.filmweb.pl/showtimes/Warszawa/Atlantic-29";



        new Connect(text, atlantic_cinema).execute();


    }
}
