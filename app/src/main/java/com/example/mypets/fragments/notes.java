package com.example.mypets.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypets.AdapterCardView;
import com.example.mypets.R;
import com.example.mypets.settings_cards;

import java.util.ArrayList;
import java.util.List;


public class notes extends Fragment{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        RecyclerView recycleViewSettings = view.findViewById(R.id.recycleViewSettings);
        recycleViewSettings.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recycleViewSettings.setLayoutManager(llm);

        List<settings_cards> cardsSettings = new ArrayList<>();
        cardsSettings.add(new settings_cards("Покормить паука", getResources().getDrawable(R.drawable.ic_koala)));
        cardsSettings.add(new settings_cards ("Поиграть с собакой", getResources().getDrawable(R.drawable.ic_koala)));
        cardsSettings.add(new settings_cards("Сходить на прививкус с кошкой", getResources().getDrawable(R.drawable.ic_koala)));
        cardsSettings.add(new settings_cards("Покормить Гуся", getResources().getDrawable(R.drawable.ic_koala)));

        recycleViewSettings.setAdapter(new AdapterCardView(getContext(), cardsSettings));


        return view;
    }

}