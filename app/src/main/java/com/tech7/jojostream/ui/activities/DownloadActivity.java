package com.tech7.jojostream.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.tech7.jojostream.R;

public class DownloadActivity extends AppCompatActivity {

    private WebView webView;
    public static final String EXTRA_TITLE = "com.tech7.jojostream.EXTRA_TITLE";  //title
    public static final String EXTRA_URL = "com.tech7.jojostream.EXTRA_URL";  //url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_URL)) {
            Log.d("DownloadActivity-URL", intent.getStringExtra(EXTRA_URL));
            if (intent.hasExtra(EXTRA_TITLE))
                setTitle(intent.getStringExtra(EXTRA_TITLE));

            String url = intent.getStringExtra(EXTRA_URL);
            webView = (WebView) findViewById(R.id.webView);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(false);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setSaveFormData(true);
            webView.loadUrl(url);
        }


    }
}
