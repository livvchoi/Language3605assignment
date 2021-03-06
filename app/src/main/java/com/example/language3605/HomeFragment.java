package com.example.language3605;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

public class HomeFragment extends Fragment {
    private Button hmSwitchTest, hmTest;

    Button buttonToCategory;

    public static Spinner languageSpinner;
    private TextView showWordofDay, showWordofDayEng, showStoryofDay;
    private CardView btnWordofDay, btnStoryofDay;
    public static List<Dictionary> langDict = new ArrayList<>();
    public static List<Story> storyList = new ArrayList<>();


    DatabaseReference databaseReference;
    DatabaseReference wotdDatabaseReference;
    DatabaseReference storyDatabaseReference;


    List<String> names;

    public static String languageClicked;


   ProgressDialogHelper progressDialogHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fragment_home, container, false);
        // Word of the Day
        //instantiate view object
        btnWordofDay = contentView.findViewById(R.id.cvWordOfDay);
        btnStoryofDay = contentView.findViewById(R.id.cvStoryofDayHome);
        showWordofDay = contentView.findViewById(R.id.tvWordofDay);
        showWordofDayEng = contentView.findViewById(R.id.tvWordofDayEng);
        showStoryofDay = contentView.findViewById(R.id.tvHomeStoryTitle);



        //switch from fragment into activity (not useful other than to log out)
        hmSwitchTest = contentView.findViewById(R.id.btFragmentSwitch);
        hmSwitchTest.setVisibility(View.INVISIBLE);
        hmSwitchTest.setText("Fragment Switch Test");
        hmSwitchTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction xfr = getParentFragmentManager().beginTransaction();
                xfr.replace(R.id.fragment_container, new CategoryFragment());
                xfr.commit();

            }
        });

        //change between fragments (HomeFragment to QuizFragment)
        hmTest = contentView.findViewById(R.id.btTest);
        hmTest.setVisibility(View.INVISIBLE);
        hmTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new QuizFragment());
                fr.commit();
            }
        });

        // to category screen
        buttonToCategory = contentView.findViewById(R.id.languageButton);
        buttonToCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction cFrag = getParentFragmentManager().beginTransaction();
                cFrag.replace(R.id.fragment_container, new CategoryFragment());
                cFrag.commit();
            }
        });


        // showing dropdown list of languages

        languageSpinner = contentView.findViewById(R.id.languageSpinner);

        names = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child("LanguagesList").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot childSnapshot:dataSnapshot.getChildren()){
                            String spinnerName = childSnapshot.child("Name").getValue(String.class);
                            names.add(spinnerName);
                        }
                        //remove the English option
                        names.remove(0);
                        final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(contentView.getContext(),android.R.layout.simple_spinner_item, names);

                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

                        languageSpinner.setAdapter(arrayAdapter);



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                languageClicked = (String) parent.getItemAtPosition(position);
                Log.v("item", languageClicked);
                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        setShowWordofDay(languageClicked);
                    }

                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //loading prompt
        this.progressDialogHelper = new ProgressDialogHelper(getContext());

        //show loading prompt
        progressDialogHelper.show("Please wait", "Loading languages...");

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                setShowStoryofDay();
            }
        });

        return contentView;


    }


    public void setShowWordofDay(String languageClicked){

        //if no language is chosen show pick a word
        if(languageClicked != null){
            String languageDictionary = languageClicked + "Dictionary";
             databaseReference.child(languageDictionary).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    for (DataSnapshot dictSnapshot : snapshot.getChildren()){
                        Dictionary dictEntry = dictSnapshot.getValue(Dictionary.class);
                        langDict.add(dictEntry);

                    }
                    //if language is chosen, pick a random word
                    Random r = new Random();
                    int wordPos  = r.nextInt(langDict.size() - 1);
                    Log.d("langDict size", (String.valueOf(langDict.size())));
                    Log.d("wordPos", (String.valueOf(wordPos)));
                    showWordofDay.setText(langDict.get(wordPos).getWord());
                    Log.d("Word of Day", langDict.get(wordPos).getWord());
                    showWordofDayEng.setText(langDict.get(wordPos).getEnglishWord());
                    Log.d("Word of Day English", langDict.get(wordPos).getEnglishWord());

                    progressDialogHelper.dismiss();

                    //redirect to dictionary if the cardview is clicked
                    btnWordofDay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putString("id", langDict.get(wordPos).getId());

                            DictionaryFragment dictionaryFragment = new DictionaryFragment();

                            dictionaryFragment.setArguments(bundle);

                            AppCompatActivity activity = (AppCompatActivity) v.getContext();
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, dictionaryFragment).addToBackStack(null).commit();
                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull @NotNull DatabaseError error) {

                }
            });


        }
        //each time the language is change the list of words should be cleared
        langDict.clear();
    }

    public void setShowStoryofDay(){

        databaseReference.child("DreamTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot storySnapshot : snapshot.getChildren()){
                    Story storyEntry = storySnapshot.getValue(Story.class);
                    storyList.add(storyEntry);

                }

                Random r = new Random();
                int storyPos  = r.nextInt(storyList.size() - 1);
                    Log.d("storyDict size", (String.valueOf(storyList.size())));
                    Log.d("storyPos", (String.valueOf(storyPos)));
                    showStoryofDay.setText(storyList.get(storyPos).getTitle());
                    Log.d("Word of Day", storyList.get(storyPos).getTitle());

                btnStoryofDay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id", storyList.get(storyPos).getID());

                        StoryFragment storyFrag = new StoryFragment();

                        storyFrag.setArguments(bundle);

                        AppCompatActivity activity = (AppCompatActivity) v.getContext();
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, storyFrag).addToBackStack(null).commit();
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }


}
