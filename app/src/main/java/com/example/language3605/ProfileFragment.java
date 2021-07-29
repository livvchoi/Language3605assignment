package com.example.language3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private Button pSignOut, pAnswerQuizTest;
    private TextView pShareProgress;

    private Profile profile;
    private List<Profile> pProfileList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_profile, container, false);

        //code here
        FirebaseAuth auth = FirebaseAuth.getInstance();

        pSignOut = contentView.findViewById(R.id.btSignOut);
        pSignOut.setText("Sign Out");
        pSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getFragmentManager().popBackStack();
                AuthUI.getInstance().signOut(getActivity())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                            }
                        });
            }
        });

        pAnswerQuizTest = contentView.findViewById(R.id.btTestAnswerQuiz);
        pAnswerQuizTest.setVisibility(View.INVISIBLE);
//        pAnswerQuizTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String testCategoryName = "Body Parts";
//                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container, new AnswerQuizFragment(testCategoryName));
//                fragmentTransaction.commit();
//            }
//        });

        //share
        pShareProgress = contentView.findViewById(R.id.tvShareProgress);
        pShareProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendText = new Intent();
                sendText.setAction(Intent.ACTION_SEND);
                sendText.putExtra(Intent.EXTRA_TEXT, "Check out my progress on LexiLearn!");
                sendText.putExtra(Intent.EXTRA_TITLE, "LexiLearn Progress");
                sendText.setType("text/plain");
                Intent shareIntent = Intent.createChooser(sendText, null);
                startActivity(shareIntent);
            }
        });

        //link to database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot profileSnapshot : snapshot.getChildren()) {
                    Profile profile = profileSnapshot.getValue(Profile.class);
                    pProfileList.add(profile);
                }

                profile = pProfileList.get(0);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        return contentView;
    }
}
