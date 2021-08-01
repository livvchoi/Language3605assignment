package com.example.language3605;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private Button pSignOut;
    private TextView pShareProgress, pQuizProgress, pTotalProgress;

    private ProgressBar pProgressBar;
    RecyclerView badgeRecyclerView;
    private final List<Badge> mBadgeList = new ArrayList<>();

    private Profile profile;
    private final List<Profile> pProfileList = new ArrayList<>();

    public String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
    BadgeAdapter badgeAdapter;


    private ProgressDialogHelper progressDialogHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_profile, container, false);

        //loading prompt
        this.progressDialogHelper = new ProgressDialogHelper(getContext());

        //show loading prompt
        progressDialogHelper.show("Please wait", "Loading badges...");

        //Logout button
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
                updateShareProgress();

                //refresh fragment
                ProfileFragment profileFragment= new ProfileFragment();

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, profileFragment).addToBackStack(null).commit();



            }
        });

        //Instantiate view objects
        pProgressBar = contentView.findViewById(R.id.progressBar);
        pQuizProgress = contentView.findViewById(R.id.tvQuizPercVal);
        pTotalProgress = contentView.findViewById(R.id.tvProgressCompletedVal);


        //link to database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.child("Profile").child(UID).addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                    Profile profile = snapshot.getValue(Profile.class);


                //set data to view objects
                pProgressBar.setProgress((int) profile.getProgress());
                pQuizProgress.setText(profile.getQuizCompleted()+ "%");
                pTotalProgress.setText(profile.getProgress() + "%");



                progressDialogHelper.dismiss();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        badgeRecyclerView = contentView.findViewById(R.id.rvBadge);
        badgeRecyclerView.setHasFixedSize(true);
        badgeRecyclerView.setLayoutManager(layoutManager);
        getBadges();
        return contentView;
    }

    private void updateShareProgress(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ref.child("Profile").child(UID).child("Badges").child("BadgeShare").child("Achieved").setValue(true);




    }

    public void getBadges(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        Log.d("User ID", UID);

        ref.child("Profile").child(UID).child("Badges").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot badgeSnapshot : snapshot.getChildren()){
                    Badge newBadge = badgeSnapshot.getValue(Badge.class);
                    mBadgeList.add(newBadge);
                   Log.d("Badge collected", newBadge.getName());
                   Log.d("Badge achieved", String.valueOf(newBadge.isAchieved()));
                }
                badgeAdapter = new BadgeAdapter(mBadgeList);
                badgeRecyclerView.setAdapter(badgeAdapter);

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}
