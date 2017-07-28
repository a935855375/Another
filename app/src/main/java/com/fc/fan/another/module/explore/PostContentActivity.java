package com.fc.fan.another.module.explore;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;

import butterknife.BindView;

/**
 * Created by fan on 7/27/17.
 * A nice day..
 */

public class PostContentActivity extends RxBaseActivity {
    public static final String TAG = PostContentActivity.class.getSimpleName();

    @BindView(R.id.post_content_toolbar)
    Toolbar toolbar;

    @BindView(R.id.post_content_webView)
    WebView mWebView;

    private WebSettings mWebViewSettings;


    @Override
    public int getLayoutId() {
        return R.layout.activity_post_content;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return true;
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("测试");
        }

        String url = "http://html5test.com/";
        initWebView();
        initWebSettings();
        initWebViewClient();
        mWebView.loadUrl(url);
    }

    private void initWebView() {
        mWebViewSettings = mWebView.getSettings();

        mWebViewSettings.setLoadsImagesAutomatically(true);

        mWebView.setDownloadListener((url, userAgent, contentDisposition, myType, contentLength) -> {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }

    private void initWebSettings() {
        mWebViewSettings.setJavaScriptEnabled(true);
        mWebViewSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebViewSettings.setDomStorageEnabled(true);
        mWebViewSettings.setDatabaseEnabled(true);
        mWebViewSettings.setDefaultTextEncodingName("utf-8");
        mWebViewSettings.setUseWideViewPort(false);
        mWebViewSettings.setSupportZoom(true);
        mWebViewSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mWebViewSettings.setSupportMultipleWindows(true);
        mWebViewSettings.setAllowFileAccess(true);
        mWebViewSettings.setNeedInitialFocus(true);
        mWebViewSettings.setBuiltInZoomControls(true);
        mWebViewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebViewSettings.setLoadWithOverviewMode(true);
        mWebViewSettings.setDisplayZoomControls(false);
    }

    private void initWebViewClient() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(getBaseContext(), "出错了", Toast.LENGTH_SHORT).show();

                if (Build.VERSION.SDK_INT >= 23)
                    Log.e(TAG, error.getDescription().toString());
            }
        });
    }

}
