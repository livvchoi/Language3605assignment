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

    String category = "Numbers";


    DatabaseReference wordDatabaseReference;

    RecyclerView wordRecyclerView;
    private List<Dictionary> mDictionary = new ArrayList<>();
    private List<Dictionary> mCategoryDictionary = new ArrayList<>();



    // categories
    private ArrayList<String> categories = new ArrayList<>();
    //  english translate
    private ArrayList<String> englishTranslate = new ArrayList<>();
    //  indig word
    private ArrayList<String> indigWords = new ArrayList<>();

    private ArrayList<String> aWords = new ArrayList<>();
    private ArrayList<String> bWords = new ArrayList<>();

//    private ArrayList<Words> mExampleList;
//    private ListOfWordsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_listofwords, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            category = bundle.get("category").toString();
        }

        //Instantiate
        wordRecyclerView = contentView.findViewById(R.id.recyclerWordList);
        wordRecyclerView.setHasFixedSize(true);
        wordRecyclerView.setLayoutManager((new LinearLayoutManager(contentView.getContext())));

        //Select correct dictionary branch from Firebase
        wordDatabaseReference = FirebaseDatabase.getInstance().getReference();
        String languageClicked = HomeFragment.item + "Dictionary";

        ValueEventListener valueEventListener = wordDatabaseReference.child(languageClicked).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    Dictionary entry = childSnapshot.getValue(Dictionary.class);
                    mDictionary.add(entry);
                }
                //check that the number of words in dictionary matches number of entries
                System.out.println("dictionary size:" + mDictionary.size());

                mCategoryDictionary.addAll(Dictionary.getCategoriesList(mDictionary, category));
                System.out.println("category size:" +mCategoryDictionary.size());

              /*  int i = 0;
                while(i<categories.size()){
                    if(CategoryAdapter.categoryPosition.equals(categories.get(i))){
                        aWords.add(englishTranslate.get(i));
                        bWords.add(indigWords.get(i));
                    }
                    i++;
                }

                System.out.println(aWords);
                System.out.println(bWords);*/

//                ListOfWordsAdapter recAdapter = new ListOfWordsAdapter(contentView.getContext(), aWords, bWords);
                ListOfWordsAdapter recAdapter = new ListOfWordsAdapter(mDictionary,mCategoryDictionary);
                wordRecyclerView.setAdapter(recAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return contentView;
    }

//    private void filter(String text) {
//        ArrayList<Words> filteredList = new ArrayList<>();
//
//        for(Words item : mExampleList) {
//            if(item.getEnglishWord().toLowerCase().contains(text.toLowerCase())) {
//                filteredList.add(item);
//            }
//        }
//
//        mAdapter.filterList(filteredList);
//    }

}
