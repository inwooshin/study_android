package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView wv;
    private String url = "https://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView)findViewById(R.id.wv);

        //자바스크립트를 허용해주는 구만
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl(url);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClientClass());
    }

    @Override
    //다양한 키들을 입력을 했을 때 특정한 동작을 수행하게 해주는 구문
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()){
            wv.goBack();

            return true;
        }

        if(keyCode == KeyEvent.KEYCODE_COPY){
            Toast.makeText(this, "클립보드로 복사했습니다!", Toast.LENGTH_SHORT).show();
        }

        return super.onKeyDown(keyCode, event);
    }


    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            wv.loadUrl(url);

            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}