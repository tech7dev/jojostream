package com.tech7.jojostream.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tech7.jojostream.R;

public class DownloadActivity extends AppCompatActivity {

    private WebView webView;
    private myWebViewClient mWebViewClient;

    public static final String EXTRA_URL = "com.tech7.jojostream.EXTRA_URL";  //url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_URL)) {
            Log.d("DownloadActivity-URL", intent.getStringExtra(EXTRA_URL));

            String url = intent.getStringExtra(EXTRA_URL);
            webView = (WebView) findViewById(R.id.webView);
            mWebViewClient = new myWebViewClient();
            //webView.setWebViewClient(mWebViewClient);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(false);
            webView.getSettings().setJavaScriptEnabled(false);
            webView.getSettings().setAppCacheEnabled(false);
            webView.getSettings().setSaveFormData(true);
            webView.loadUrl(url);

//            webView.setDownloadListener(new DownloadListener() {
//                public void onDownloadStart(String url, String userAgent,
//                                            String contentDisposition, String mimetype,
//                                            long contentLength) {
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    startActivity(i);
//                }
//            });
        }


    }
    class myWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Uri.parse(url).getHost().contains("fichier")) {
                return false;
            }

            return true;
        }
    }

}
