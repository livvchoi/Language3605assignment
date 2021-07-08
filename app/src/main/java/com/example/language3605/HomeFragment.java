package com.example.language3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {
    private Button hmSwitchTest, hmTest;

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

        return contentView;


    }


}
