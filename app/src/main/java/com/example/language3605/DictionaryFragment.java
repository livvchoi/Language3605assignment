package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DictionaryFragment extends Fragment {
    private static final String TAG = "DisplayFragment";

    DatabaseReference displayDatabaseReference;

    FirebaseStorage storage;
    StorageReference storageRef, imageRef;

    private TextView showEnglish, showIndig;

    private ImageView showImage;

    //use the dictionary object
    public static ArrayList<Dictionary> dictList = new ArrayList<>();
    /*public static ArrayList<String> englishWord = new ArrayList<>();
    public static ArrayList<String> indigWord = new ArrayList<>();


    ArrayList<String> images = new ArrayList<>();

     */

    String aWords;
    String bWords;
    String aimages;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_dictionary, container, false);

        //Connect to XML
        showEnglish = contentView.findViewById(R.id.english_textView);
        showIndig = contentView.findViewById(R.id.indig_textView);
        showImage = contentView.findViewById(R.id.wordImage);

        //Firebase storage initialization
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

        //
        displayDatabaseReference = FirebaseDatabase.getInstance().getReference();

        String languageClicked = HomeFragment.item + "Dictionary";

        ValueEventListener valueEventListener = displayDatabaseReference.child(languageClicked).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //pull from Dictionary entries from Firebase
                //TODO: specify which dictionary to pull from
                for (DataSnapshot dictSnapshot : dataSnapshot.getChildren()) {
                    Dictionary dictEntry = dictSnapshot.getValue(Dictionary.class);
                    dictList.add(dictEntry);

                }

                //Search for the word which was clicked
                for (int i = 0; i < dictList.size(); i++) {
                    if (ListOfWordsAdapter.englishPosition.equals(dictList.get(i).getEnglishWord())) {
                        showEnglish.setText(dictList.get(i).getEnglishWord());
                        showIndig.setText(dictList.get(i).getWord());
                        Picasso.get().load(dictList.get(i).getImage()).resize(100, 100).centerCrop().into(showImage);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //System.out.println("stood: " + ListOfWordsAdapter.englishPosition);


//                StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images/Numbers/two.png");


//                System.out.println("printing:" +  aimages);


//                Picasso.get().load().into(showImage);


//                final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(contentView.getContext(),aWords,bWords,aImages);
//
//
//                DisplayAdapter adapter = new DisplayAdapter(contentView.getContext(), aWords, bWords, aImages);


//        int i = 0;
//        while (i < englishWord.size()) {
//            if (ListOfWordsAdapter.englishPosition.equals(englishWord.get(i))) {
//                storageReference = FirebaseStorage.getInstance().getReference();
//
//
//                Task<Uri> ref = storageReference.child("images/Numbers/two.png").getDownloadUrl();
//
////
////                ValueEventListener valueEventListener1 = displayDatabaseReference.child(languageClicked).child(Integer.toString(i)).addValueEventListener(new ValueEventListener() {
////                @Override
////                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
////                        String aImage = childSnapshot.child("Image").getValue(String.class);
//                RequestOptions requestOptions = new RequestOptions();
//                requestOptions.placeholder(R.drawable.three);
//                        Glide.with(contentView.getContext()).applyDefaultRequestOptions(requestOptions).load(ref).into(showImage);
//
////                        StorageReference ref = storageReference.child(retrievedName).child("images/profile_image").getDownloadUrl();
//
//
//                    }
//            i++;
//
//        }


        return contentView;
    }


}
