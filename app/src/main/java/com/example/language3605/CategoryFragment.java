package com.example.language3605;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class CategoryFragment extends Fragment {

    private static final String TAG = "CategoryFragment";

    DatabaseReference catDatabaseReference;

    RecyclerView catRecyclerView;
    private TextView mSpeaker, mLanguage, mCountry, mStateTerritory,mDescription;

    // to be deleted
    FloatingActionButton buttonToAddCategory;

    private final ArrayList<String> mLanguages = new ArrayList<>();
    private final ArrayList<String> aCategories = new ArrayList<>();
    private final ArrayList<String> bCategories = new ArrayList<>();
    private final ArrayList<String> catIcons = new ArrayList<>();
    public static List<Language> langDetailsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_categorylist, container, false);

        //to be deleted
        buttonToAddCategory = contentView.findViewById(R.id.fltBtnAddCat);
        buttonToAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction qFrag = getParentFragmentManager().beginTransaction();
                qFrag.replace(R.id.fragment_container, new AddCategoryFragment());
                qFrag.commit();
            }
        });

        //Instantiate view objects
        mCountry = contentView.findViewById(R.id.tvTraditionalLand);
        mLanguage = contentView.findViewById(R.id.tvLanguageName);
        mDescription = contentView.findViewById(R.id.tvLangDescription);
        mSpeaker = contentView.findViewById(R.id.tvSpeakers);
        mStateTerritory = contentView.findViewById(R.id.tvLangState);
        catRecyclerView = contentView.findViewById(R.id.categoryRecycler);
        catRecyclerView.setHasFixedSize(true);
        catRecyclerView.setLayoutManager((new LinearLayoutManager(contentView.getContext())));

        catDatabaseReference = FirebaseDatabase.getInstance().getReference();
        ValueEventListener valueEventListener = catDatabaseReference.child("CategoriesLocale").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String category = childSnapshot.child("Language").getValue(String.class);
                    String categoryA = childSnapshot.child("language").getValue(String.class) ;
                    mLanguages.add(category);
                    mLanguages.add(categoryA);

                    String aCategory = childSnapshot.child("Category").getValue(String.class);
                    String bCategory = childSnapshot.child("category").getValue(String.class);
                    aCategories.add(aCategory);
                    aCategories.add(bCategory);

                }

                int i = 0;

                while (i < mLanguages.size()){
                    if (HomeFragment.languageClicked.equals(mLanguages.get(i))){
                        bCategories.add(aCategories.get(i));
                    }
                    i++;
                }

                System.out.println(bCategories);



            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });

        ValueEventListener valueEventListener2 = catDatabaseReference.child("CategoriesList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String catIconImage = childSnapshot.child("Images").getValue(String.class);
                    catIcons.add(catIconImage);
                    Log.d(TAG, "catIconImage: " + catIconImage);
                }

                CategoryAdapter recAdapter = new CategoryAdapter(contentView.getContext(), bCategories, catIcons);
                catRecyclerView.setAdapter(recAdapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        //set language details
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ValueEventListener valueEventListener3 = catDatabaseReference.child("LanguagesList").addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot languageSnapshot : dataSnapshot.getChildren()) {
                            Language lang = languageSnapshot.getValue(Language.class);
                            langDetailsList.add(lang);
//                    Log.d(TAG, "catIconImage: " + catIconImage);
                        }

                        Language langDisplay = Language.getLanguage(langDetailsList, HomeFragment.languageClicked);
                        mLanguage.setText(langDisplay.getName());
                        mCountry.setText("Traditional Land: " + langDisplay.getCountry());
                        DecimalFormat df = new DecimalFormat("#,###,###,###");
                        mSpeaker.setText("Active Speakers: "+df.format(langDisplay.getSpeakers()));
                        mStateTerritory.setText("State or Territory: "+langDisplay.getStateTerritory());
                        mDescription.setMovementMethod(new ScrollingMovementMethod());
                        mDescription.setText(langDisplay.getDescription());
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
            }
        });

        return contentView;
    }

}


