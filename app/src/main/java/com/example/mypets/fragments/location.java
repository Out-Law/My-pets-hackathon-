package com.example.mypets.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.mypets.R;


public class location extends Fragment {

    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_location, container, false);
        /*webView = (WebView) view.findViewById(R.id.map);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://developer.alexanderklimov.ru/android");*/
        return view;
    }
}