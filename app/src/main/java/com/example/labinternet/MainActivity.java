package com.example.labinternet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    TextView text;
    Button getText, getImage, goToSite, getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getText = findViewById(R.id.button);
        text = findViewById(R.id.textview);


        getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Textparse().execute();

            }
        });


        goToSite = findViewById(R.id.button3);
        goToSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoStie = new Intent(getApplicationContext(), com.example.labinternet.webVIew.class);
                startActivity(gotoStie);
            }
        });


        getImage = findViewById(R.id.button2);
        getImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoImageParse = new Intent(getApplicationContext(), com.example.labinternet.ImageParser.class);
                startActivity(gotoImageParse);
            }
        });


        getData = findViewById(R.id.button5);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DataParse().execute();
            }
        });

    }
//<div class="ytp-cued-thumbnail-overlay-image" style="background-image: url(&quot;https://i.ytimg.com/vi_webp/vApsErTM3Zs/maxresdefault.webp&quot;);"></div>

    public class DataParse extends AsyncTask<Void, Void, Void> {
        String words;


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.auca.kg").timeout(6000).get();
                Elements header = doc.select("h2");
                words = header.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            text.setText(words);
        }
    }

    public class Textparse extends AsyncTask<Void, Void, Void> {
        String words;


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://www.auca.kg").timeout(6000).get();
                Elements title = doc.select("#9529b78");
                System.out.println(title.text());
                words = doc.text();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            text.setText(words);
        }
    }


}