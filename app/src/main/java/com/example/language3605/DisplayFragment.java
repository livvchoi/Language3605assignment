package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class DisplayFragment extends Fragment {
    private static final String TAG = "DisplayFragment";

    DatabaseReference displayDatabaseReference;

    RecyclerView displayRecyclerView;

    // categories
    private ArrayList<String> categories = new ArrayList<>();
    //  english translate
    private ArrayList<String> englishTranslate = new ArrayList<>();
    //  indig word
    private ArrayList<String> indigWords = new ArrayList<>();

    private ArrayList<String> aWords = new ArrayList<>();
    private ArrayList<String> bWords = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_template, container, false);

        //code here

        return contentView;
    }
}
