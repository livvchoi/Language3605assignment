package com.example.language3605;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    private final ArrayList<Query> mLanguage = new ArrayList<com.google.firebase.database.Query>();
    private final ArrayList<Query> mLocation = new ArrayList<Query>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");



        showLanguageNLocation();

    }

    private void showLanguageNLocation() {
        Log.d(TAG, "showLanguageNLocation: show language n location");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("LanguagesList");

//        System.out.println(FirebaseDatabase.getInstance().getReference("LanguagesList").child("0").child("Name"));

        System.out.println(reference.child("Name"));

        mLanguage.add(reference.orderByChild("Name"));
        mLocation.add(reference.orderByChild("StateTerritory"));

//
//        mLanguage.add("Tiwi");
//        mLocation.add("Tiwi Islands: Northern Australia");
//
//        mLanguage.add("Kriol");
//        mLocation.add("New South Wales");
//
//        mLanguage.add("Gurindiji");
//        mLocation.add("Northern Territory");
//
//        mLanguage.add("Warlpiri");
//        mLocation.add("Northern Territory");

//        showRecyclerView();
    }

//    private void showRecyclerView() {
//        Log.d(TAG, "showRecyclerView: show RecyclerView");
//        RecyclerView recyclerView = findViewById(R.id.rv_languages);
//        LanguageAdapter adapter = new LanguageAdapter(this, mLanguage, mLocation);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
}