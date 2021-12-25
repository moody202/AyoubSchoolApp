package com.ayoubschool.ayoubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class contact extends AppCompatActivity {
        WebView webView;
        Button home;
        SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FIRST_SUB_WINDOW);
        setContentView(R.layout.activity_contact);


        webView=findViewById(R.id.webView);
        webView.loadUrl("https://www.fikrtanys.com/p/contact-us.html");
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setUseWideViewPort(true);
        webSettings.getCursiveFontFamily().getBytes(StandardCharsets.UTF_8);
        webSettings.supportMultipleWindows();


//        Button Home
        home =findViewById(R.id.homeabout);
        home.setText("Hallo in My App");


//        Refresh

        swipeRefreshLayout=findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getApplicationContext(), "Refresh", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    public void home(View view){
        webView.loadUrl("https://www.fikrtanys.com/");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean result = true;
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
        } else {
            result = super.onKeyDown(keyCode, event);
        }
        return result;
    }
//        public void back(View view){
//        webView.goBack();
//        }
        public void back(View view){
            Intent back=new Intent(this,MainActivity.class);
            startActivity(back);
            }
}