package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddWordFragment extends Fragment {

    DatabaseReference addDatabaseReference;

    Button buttonToListOfFragment;

    EditText addIndigWord;
    EditText addEngWord;
    EditText addDefine;

    String languageClicked = HomeFragment.languageClicked + "Dictionary";

    DatabaseReference databaseWords = FirebaseDatabase.getInstance().getReference(languageClicked);

    String category;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_addword, container, false);

        buttonToListOfFragment = contentView.findViewById(R.id.button5);
        buttonToListOfFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction qFrag = getParentFragmentManager().beginTransaction();
                qFrag.replace(R.id.fragment_container, new ListOfWordsFragment());
                qFrag.commit();

                addData();
            }
        });

        addIndigWord = contentView.findViewById(R.id.wordPlainText);
        addEngWord = contentView.findViewById(R.id.wordPlainText2);
        addDefine = contentView.findViewById(R.id.define);

        //code here

        return contentView;
    }

    private void addData(){
        String categoryId = CategoryAdapter.categoryPosition;
        String Category = ListOfWordsFragment.category;
        String engWord = addEngWord.getText().toString().trim();
        String idd = databaseWords.push().getKey();
        String image = databaseWords.push().getKey();
        String Language = HomeFragment.languageClicked;
        Integer rating = 10;
        String indigWord = addIndigWord.getText().toString().trim();
        String define = addDefine.getText().toString().trim();
        String id = databaseWords.push().getKey();


        Dictionary dictionary = new Dictionary(categoryId, Category, engWord, idd, image, Language, rating, indigWord, define);


        databaseWords.child(id).setValue(dictionary);

    }
}
