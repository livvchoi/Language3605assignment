package com.example.language3605;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DictionaryFragment extends Fragment {
    private static final String TAG = "DisplayFragment";

    DatabaseReference displayDatabaseReference;

    private TextView showEnglish, showIndig, showDefinition, showRating;
    private ImageView showImage, mUpvote, mDownvote;
    private String id;
    Context mContext;

    //use the dictionary object
    public static ArrayList<Dictionary> dictList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_dictionary, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            id = bundle.get("id").toString();
        }
        //Instantiate view objects
        showEnglish = contentView.findViewById(R.id.tvEngWord);
        showIndig = contentView.findViewById(R.id.tvIndigWord);
        showImage = contentView.findViewById(R.id.wordImage);
        showDefinition = contentView.findViewById(R.id.tvDefinition);
        showRating = contentView.findViewById(R.id.tvRating);
        mUpvote = contentView.findViewById(R.id.ivUpvote);
        mDownvote = contentView.findViewById(R.id.ivDownvote);

        //Specify which language dictionary to reference in Firebase Realtime Database
        String languageClicked = HomeFragment.item + "Dictionary";
        displayDatabaseReference = FirebaseDatabase.getInstance().getReference();

        ValueEventListener valueEventListener = displayDatabaseReference.child(languageClicked).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //pull from Dictionary entries from Firebase
                for (DataSnapshot dictSnapshot : dataSnapshot.getChildren()) {
                    Dictionary dictEntry = dictSnapshot.getValue(Dictionary.class);
                    dictList.add(dictEntry);

                }
                //Search for the word which was clicked
                Dictionary wordClicked = Dictionary.getDictionaryEntry(dictList, id);

                //Display details
                showEnglish.setText(wordClicked.getEnglishWord());
                showIndig.setText(wordClicked.getWord());
                showDefinition.setText(wordClicked.getDefinition());
                showRating.setText(wordClicked.getRating().toString());
                Picasso.get().load(wordClicked.getImage()).into(showImage);

                mUpvote.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                mDownvote.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return contentView;
    }


}
