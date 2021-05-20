package com.example.labinternet;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class webVIew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_v_iew);
        WebView webView = (WebView) findViewById(R.id.webiew);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.auca.kg");
    }


}