package com.example.language3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private Button hmSwitchTest, hmTest;

    Spinner languageSpinner;

    DatabaseReference databaseReference;

    List<String> names;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fragment_home, container, false);

        //switch from fragment into activity (not useful other than to log out)
        hmSwitchTest = contentView.findViewById(R.id.btFragmentSwitch);
        hmSwitchTest.setText("Fragment Switch Test");
        hmSwitchTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });

        //change between fragments (HomeFragment to QuizFragment)
        hmTest = contentView.findViewById(R.id.btTest);
        hmTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                FragmentTransaction fr = getParentFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new QuizFragment());
                fr.commit();
            }
        });

        // showing dropdown list of languages

        languageSpinner = (Spinner) contentView.findViewById(R.id.languageSpinner);

        names = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("LanguagesList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot childSnapshot:dataSnapshot.getChildren()){
                    String spinnerName = childSnapshot.child("Name").getValue(String.class);
                    names.add(spinnerName);
                }

                final ArrayAdapter arrayAdapter = new ArrayAdapter<String>(contentView.getContext(),android.R.layout.simple_spinner_item, names);

                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

                languageSpinner.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return contentView;


    }


}
