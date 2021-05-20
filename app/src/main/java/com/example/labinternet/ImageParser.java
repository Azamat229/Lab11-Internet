package com.example.labinternet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageParser extends AppCompatActivity {
    ImageView image;
    Bitmap bsr;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_parser);
         image = (ImageView) (findViewById(R.id.imageView));
         new ImageParse().execute();
         btn = findViewById(R.id.button4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoImageParse = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(gotoImageParse);
            }
        });
    }


    public class ImageParse extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                 bsr = BitmapFactory.decodeStream((InputStream) new URL("https://auca.kg/uploads/00012021/Бекжон.jpg").getContent());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            image.setImageBitmap(bsr);
        }
    }
}