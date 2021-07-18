package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListOfWordsFragment extends Fragment {

    private static final String TAG = "ListOfWordsFragment";

    DatabaseReference wordDatabaseReference;

    RecyclerView wordRecyclerView;

    private ArrayList<String> mWords = new ArrayList<>();

    List<String> words;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_listofwords, container, false);

        wordRecyclerView = contentView.findViewById(R.id.categoryRecycler);
        wordRecyclerView.setHasFixedSize(true);
        wordRecyclerView.setLayoutManager((new LinearLayoutManager(contentView.getContext())));

        wordDatabaseReference = FirebaseDatabase.getInstance().getReference();
        ValueEventListener valueEventListener = wordDatabaseReference.child("CategoriesList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String category = childSnapshot.child("Name").getValue(String.class);
                    mWords.add(category);
                }

//                CategoryAdapter recAdapter = new CategoryAdapter(contentView.getContext(), mWords);

//                wordRecyclerView.setAdapter(recAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return contentView;
    }
}
