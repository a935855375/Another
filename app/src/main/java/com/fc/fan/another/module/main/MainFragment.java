package com.fc.fan.another.module.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxLazyFragment;
import com.fc.fan.another.utils.PreferenceUtil;

import butterknife.BindView;

/**
 * Created by fan on 7/27/17.
 * A nice day..
 */

public class MainFragment extends RxLazyFragment {
    public static final String TAG = MainFragment.class.getSimpleName();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @BindView(R.id.main_webView)
    WebView mWebView;

    private WebSettings mWebViewSettings;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public void finishCreateView(Bundle state) {
        String url = PreferenceUtil.baseUrl + "ff/index.jsp";
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
                Toast.makeText(getContext(), "出错了", Toast.LENGTH_SHORT).show();

                if (Build.VERSION.SDK_INT >= 23)
                    Log.e(TAG, error.getDescription().toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        mWebView.destroy();
        super.onDestroyView();
    }
}
