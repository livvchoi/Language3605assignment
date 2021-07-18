package com.example.language3605;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DisplayFragment extends Fragment {
    private static final String TAG = "DisplayFragment";

    DatabaseReference displayDatabaseReference;

    FirebaseStorage storage;
    StorageReference storageRef,imageRef;

    private TextView showEnglish,showIndig;

    private ImageView showImage;

    public static ArrayList<String> englishWord = new ArrayList<>();
    public static ArrayList<String> indigWord = new ArrayList<>();


    ArrayList<String> images = new ArrayList<>();

    String aWords;
    String bWords;
    String aimages;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_display, container, false);

        showEnglish = (TextView) contentView.findViewById(R.id.english_textView);
        showIndig = (TextView) contentView.findViewById(R.id.indig_textView);
        showImage = (ImageView) contentView.findViewById(R.id.wordImage);

        storage = FirebaseStorage.getInstance();

        //creates a storage reference
        storageRef = storage.getReference();

        displayDatabaseReference = FirebaseDatabase.getInstance().getReference();

        String languageClicked = HomeFragment.item + "Dictionary";

        ValueEventListener valueEventListener = displayDatabaseReference.child(languageClicked).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {

                    String aCategory = childSnapshot.child("EnglishWord").getValue(String.class);
                    englishWord.add(aCategory);

                    String bCategory = childSnapshot.child("Word").getValue(String.class);
                    indigWord.add(bCategory);

                    String aImage = childSnapshot.child("Image").getValue(String.class);
                    images.add(aImage);

                }
                System.out.println("stood: " + ListOfWordsAdapter.englishPosition);
                System.out.println("gettt: " + englishWord.get(0));

                int i = 0;
                while (i < englishWord.size()) {
                    if (ListOfWordsAdapter.englishPosition.equals(englishWord.get(i))) {
                        aWords = (englishWord.get(i));
                        bWords = (indigWord.get(i));
                        aimages= (images.get(i));
                    }
                    i++;
                }

//                StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images/Numbers/two.png");
                Picasso.get().load(aimages).resize(100,100).centerCrop().into(showImage);



//                System.out.println("printing:" +  aimages);

                showEnglish.setText(aWords);
                showIndig.setText(bWords);

//                Picasso.get().load().into(showImage);



//                final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(contentView.getContext(),aWords,bWords,aImages);
//
//
//                DisplayAdapter adapter = new DisplayAdapter(contentView.getContext(), aWords, bWords, aImages);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



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
