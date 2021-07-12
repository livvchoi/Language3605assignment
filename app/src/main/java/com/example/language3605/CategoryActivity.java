package com.example.language3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    private static final String TAG = "CategoryActivity";

    private ArrayList<String> mCategories = new ArrayList<>();

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Log.d(TAG, "onCreate: started");

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
          public void onClick(View v) {
              Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
              CategoryActivity.this.startActivity(intent);
          }
      });

        getIncomingIntent();

    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if(getIntent().hasExtra("language_type")){
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String language = getIntent().getStringExtra("language_type");
        }

        showCategories();
    }

    private void showCategories(){
        Log.d(TAG, "showCategories: show categories");

        mCategories.add("Numbers");
        mCategories.add("Greetings/Exclamations");
        mCategories.add("Kinship");
        mCategories.add("Body Parts");
        mCategories.add("Animals");
        mCategories.add("Weather");
        mCategories.add("Insects");
        mCategories.add("Emotions");
        mCategories.add("Pronouns");

        showCategoryRecyclerView();
    }

    private void showCategoryRecyclerView(){
        Log.d(TAG,"showCategoryRecyclerView: showing category RecyclerView");
        RecyclerView recyclerView = findViewById(R.id.rv_categories);
        CategoryAdapter adapter = new CategoryAdapter(this, mCategories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
    }

}