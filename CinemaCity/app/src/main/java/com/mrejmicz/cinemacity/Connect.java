package com.mrejmicz.cinemacity;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Connect extends AsyncTask<Void, Void, Void> {


    private String content;
    private TextView textView;
    private String url;

    public Connect(TextView textView, String url) {
        this.setTextView(textView);
        this.setUrl(url);
    }


    @Override
    protected Void doInBackground(Void... params) {

        try {

            Document doc = Jsoup.connect(url).get();

            content="";
            StringBuffer sb = new StringBuffer(content);


            Elements cinemaFilms = doc.getElementsByClass("filmTitle gwt-filmPage");
            int index = 0;

            for (Element film: cinemaFilms){
                sb.append((++index) + ". ");
                sb.append(film.text());
                sb.append("\n");
            }


            content = sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        textView.setText(content);
    }

    public String getContent() {
        return content;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
