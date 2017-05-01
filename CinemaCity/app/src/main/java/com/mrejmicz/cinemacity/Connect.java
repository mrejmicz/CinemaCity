package com.mrejmicz.cinemacity;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mklimek.frameviedoview.FrameVideoView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Connect extends AsyncTask<Void, Void, Void> {

    private String url;
    private FrameVideoView frameVideoView;
    private ListView listView;
    private Context context;
    private String[] adapterContent;
    String[] filmNotes = null;
    Boolean[] isFilmExtended = null;
    String[] filmTitles = null;
    String[] filmTimes = null;


    public Connect(ListView listView, String url, FrameVideoView frameVideoView, Context context) {
        this.listView = listView;
        this.url = url;
        this.frameVideoView = frameVideoView;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {

            Document doc = Jsoup.connect(url).get();


            Elements films = doc.getElementsByClass("sticker bottom-20");

            Element[] filmBoxes = new Element[films.size()];
            Element[] seancesTables = new Element[films.size()];
            filmTitles = new String[films.size()];
            filmTimes = new String[films.size()];
            isFilmExtended = new Boolean[films.size()];

            filmNotes = new String[films.size()];

            adapterContent = new String[films.size()];

            int i = 0;


            for (Element film : films) {
                filmBoxes[i] = film.select(".filmBox").first();
                seancesTables[i] = film.select(".seances-table").first();
                filmTitles[i] = film.getElementsByClass("filmTitle gwt-filmPage").first().text();
                filmTimes[i] = film.select(".filmTime").first().text();
                isFilmExtended[i] = Boolean.FALSE;

                if (film.select(".filmPlot").first() != null)
                    filmNotes[i] = film.select(".filmPlot").first().text();

                else filmNotes[i] = film.select(".filmDescription").first().text();

                adapterContent[i] = filmTitles[i] + "  " + filmTimes[i];

                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.films_list_item, adapterContent);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(isFilmExtended[position].equals(Boolean.FALSE)){
                    adapterContent[position] += "\n\n" + filmNotes[position];
                }
                else {
                    adapterContent[position] = filmTitles[position] + "  " + filmTimes[position];
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.films_list_item, adapterContent);
                listView.setAdapter(adapter);
                Toast.makeText(context, "Kliknieto " + (int) id, Toast.LENGTH_SHORT).show();
                isFilmExtended[position]  = !isFilmExtended[position];

            }
        });

        listView.setVisibility(View.VISIBLE);
        frameVideoView.onPause();
        frameVideoView.setVisibility(View.INVISIBLE);
    }

}
