package com.example.language3605;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private static final String TAG = "CategoryFragment";

    DatabaseReference catDatabaseReference;

    RecyclerView catRecyclerView;

    // to be deleted
    Button buttonToQuizFragment;

    private ArrayList<String> mLanguages = new ArrayList<>();
    private ArrayList<String> aCategories = new ArrayList<>();
    private ArrayList<String> bCategories = new ArrayList<>();
    private ArrayList<String> catIcons = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_categorylist, container, false);

        //to be deleted
        buttonToQuizFragment = contentView.findViewById(R.id.button2);
        buttonToQuizFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction qFrag = getParentFragmentManager().beginTransaction();
                qFrag.replace(R.id.fragment_container, new QuizFragment());
                qFrag.commit();
            }
        });

        catRecyclerView = contentView.findViewById(R.id.categoryRecycler);
        catRecyclerView.setHasFixedSize(true);
        catRecyclerView.setLayoutManager((new LinearLayoutManager(contentView.getContext())));

        catDatabaseReference = FirebaseDatabase.getInstance().getReference();
        ValueEventListener valueEventListener = catDatabaseReference.child("CategoriesLocale").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String category = childSnapshot.child("Language").getValue(String.class);
                    mLanguages.add(category);

                    String aCategory = childSnapshot.child("Category").getValue(String.class);
                    aCategories.add(aCategory);
                }

                int i = 0;

                while (i < mLanguages.size()){
                    if (HomeFragment.item.equals(mLanguages.get(i))){
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

        return contentView;
    }

}


