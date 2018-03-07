package com.example.admin.dailynews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

/**
 * Created by ADMIN on 06-03-2018.
 */

public class InfoActivtity extends AppCompatActivity {

        WebView webView;
        ProgressBar loader;
        String url = "";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_layout);

            Intent intent = getIntent();
            url = intent.getStringExtra("url");
            loader = (ProgressBar) findViewById(R.id.loader);
            webView = (WebView) findViewById(R.id.webView);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(false);
            webView.loadUrl(url);


            webView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    if (progress == 100) {
                        loader.setVisibility(View.GONE);
                    } else {
                        loader.setVisibility(View.VISIBLE);
                    }
                }
            });

        }

}
