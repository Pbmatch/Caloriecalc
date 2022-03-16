package com.calorie.calc.fragments.recipe.scrolling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calorie.calc.R;
import com.calorie.calc.utils.BackPressable;

public class WebViewFragment extends Fragment implements BackPressable {
    private String url;
    private WebView webView;
    private boolean startLoading=false;
    private ProgressBar progressBar;
    View view;
    public WebViewFragment(String url) {
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_web_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view=view;

    }
    public void startLoadUrl()
    {
        if(!startLoading)
        {  webView=view.findViewById(R.id.webview);
            progressBar =view.findViewById(R.id.progressbar);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress)
                {


                        progressBar.setProgress(progress);
                        if(progressBar.getVisibility()==View.GONE)
                        {
                            progressBar.setVisibility(View.VISIBLE);
                        }
                        if(progress>98)
                        {progressBar.setVisibility(View.GONE);}



                }


            });

            webView.loadUrl(url);
        startLoading=true;}
    }



    @Override
    public boolean onBackPressed() {
        getParentFragmentManager().popBackStack();
        return false;
    }
}