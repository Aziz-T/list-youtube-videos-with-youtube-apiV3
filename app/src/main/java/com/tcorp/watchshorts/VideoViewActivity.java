package com.tcorp.watchshorts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class VideoViewActivity extends AppCompatActivity {
    private WebView webView;
    private String videoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        webView = findViewById(R.id.webViewActivity);
        videoId = getIntent().getStringExtra("videoId");

        webView.loadUrl("https://www.youtube.com/shorts/"+videoId);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.setWebViewClient(new WebViewClient());
    }
}