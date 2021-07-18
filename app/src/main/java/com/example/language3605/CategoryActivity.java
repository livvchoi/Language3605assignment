//package com.example.language3605;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CategoryActivity extends AppCompatActivity {
//    private static final String TAG = "CategoryActivity";
//
//    private ArrayList<String> mCategories = new ArrayList<>();
//
//    private Button buttontoCategory;
//
//    DatabaseReference categoryDatabaseReference;
//
//    List<String> categories;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_categories);
//
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                new CategoryFragment()).commit();
//
//
////
////        buttontoCategory = findViewById(R.id.button_next);
////        buttontoCategory.setOnClickListener(new View.OnClickListener() {
////        @Override
////          public void onClick(View v) {
////              Intent intent = new Intent(CategoryActivity.this, HomeFragment.class);
////              CategoryActivity.this.startActivity(intent);
////          }
////      });
////
////
////        showCategories();
//
//    }
//
//    //    /bottom navigation change fragment
//    public BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment selectedFragment = null;
//
//                    switch (item.getItemId()) {
//                        case R.id.nav_home:
//                            selectedFragment = new HomeFragment();
//                            break;
//                        case R.id.nav_quiz:
//                            selectedFragment = new QuizFragment();
//                            break;
//                        case R.id.nav_profile:
//                            selectedFragment = new ProfileFragment();
//                            break;
//                    }
//
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).commit();
//
//                    return true;
//                }
//            };
//
//
//
////    private void getIncomingIntent(){
////        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
////        if(getIntent().hasExtra("language_type")){
////            Log.d(TAG, "getIncomingIntent: found intent extras");
////
////            String language = getIntent().getStringExtra("language_type");
////        }
////    }
////
////    private void showCategories(){
////        Log.d(TAG, "showCategories: show categories");
////
////        categories = new ArrayList<>();
////
////        categoryDatabaseReference = FirebaseDatabase.getInstance().getReference();
////        categoryDatabaseReference.child("CategoriesList").addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////
////                for(DataSnapshot childSnapshot:dataSnapshot.getChildren()){
////                    String spinnerName = childSnapshot.child("Name").getValue(String.class);
////                    categories.add(spinnerName);
////                }
////
////                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(CategoryActivity.this,android.R.layout.simple_spinner_item, categories);
////
////                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
////
////                categories.setAdapter(arrayAdapter);
////
////        mCategories.add("Numbers");
////        mCategories.add("Greetings/Exclamations");
////        mCategories.add("Kinship");
////        mCategories.add("Body Parts");
////        mCategories.add("Animals");
////        mCategories.add("Weather");
////        mCategories.add("Insects");
////        mCategories.add("Emotions");
////        mCategories.add("Pronouns");
////
////        showCategoryRecyclerView();
////    }
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////
////            }
////
////            private void showCategoryRecyclerView(){
////        Log.d(TAG,"showCategoryRecyclerView: showing category RecyclerView");
////        RecyclerView recyclerView = findViewById(R.id.rv_categories);
////        CategoryAdapter adapter = new CategoryAdapter(this, mCategories);
////        recyclerView.setAdapter(adapter);
////        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
////    }
//
//}