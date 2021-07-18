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
        View contentView = inflater.inflate(R.layout.fragment_listofwords, container, false);

        wordRecyclerView = contentView.findViewById(R.id.recyclerWordList);
        wordRecyclerView.setHasFixedSize(true);
        wordRecyclerView.setLayoutManager((new LinearLayoutManager(contentView.getContext())));

        wordDatabaseReference = FirebaseDatabase.getInstance().getReference();

        String categoryClicked = HomeFragment.item + "Dictionary";

        ValueEventListener valueEventListener = wordDatabaseReference.child(categoryClicked).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String category = childSnapshot.child("CategoryName").getValue(String.class);
                    categories.add(category);

                    String aCategory = childSnapshot.child("EnglishWord").getValue(String.class);
                    englishTranslate.add(aCategory);

                    String bCategory = childSnapshot.child("Word").getValue(String.class);
                    indigWords.add(bCategory);

                }

                System.out.println(categories.size());

                int i = 0;
                while(i<categories.size()){
                    if(CategoryAdapter.categoryPosition.equals(categories.get(i))){
                        aWords.add(englishTranslate.get(i));
                        bWords.add(indigWords.get(i));
                    }
                    i++;
                }

                System.out.println(aWords);
                System.out.println(bWords);



                ListOfWordsAdapter recAdapter = new ListOfWordsAdapter(contentView.getContext(), aWords, bWords);
                wordRecyclerView.setAdapter(recAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return contentView;
    }
}
