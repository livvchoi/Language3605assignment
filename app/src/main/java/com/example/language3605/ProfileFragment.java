package com.example.language3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private Button pSignOut, pAnswerQuizTest;
    private TextView pShareProgress;
    private ImageView pProgress1Quiz, pProgress5Quiz, pProgress20Quiz, pProgress1Language,
            pProgress3Language, pProgress5Language, pProgressShare, pProgress10LB, pProgress1LB;
    private ProgressBar pProgressBar;

    private Profile profile;
    private List<Profile> pProfileList = new ArrayList<>();
    private int progressNum;
    private int quizNum;
    private int languageNum;

    private ProgressDialogHelper progressDialogHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_profile, container, false);

        //code here

        //loading prompt
        this.progressDialogHelper = new ProgressDialogHelper(getContext());

        //show loading prompt
        progressDialogHelper.show("loading", "loading badges...");

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
                pProgressShare.setVisibility(View.VISIBLE);
            }
        });

        //link imageview references
        pProgress1Quiz = contentView.findViewById(R.id.ivProgress1Quiz);
        pProgress1Quiz.setVisibility(View.INVISIBLE);
        pProgress5Quiz = contentView.findViewById(R.id.ivProgress5Quiz);
        pProgress5Quiz.setVisibility(View.INVISIBLE);
        pProgress20Quiz = contentView.findViewById(R.id.ivProgress20Quiz);
        pProgress20Quiz.setVisibility(View.INVISIBLE);
        pProgress1Language = contentView.findViewById(R.id.ivProgress1Language);
        pProgress1Language.setVisibility(View.INVISIBLE);
        pProgress3Language = contentView.findViewById(R.id.ivProgress3Language);
        pProgress3Language.setVisibility(View.INVISIBLE);
        pProgress5Language = contentView.findViewById(R.id.ivProgress5Language);
        pProgress5Language.setVisibility(View.INVISIBLE);
        pProgressShare = contentView.findViewById(R.id.ivProgressShare);
        pProgressShare.setVisibility(View.INVISIBLE);
        pProgress10LB = contentView.findViewById(R.id.ivProgress10LB);
        pProgress10LB.setVisibility(View.INVISIBLE);
        pProgress1LB = contentView.findViewById(R.id.ivProgress1LB);
        pProgress1LB.setVisibility(View.INVISIBLE);

        pProgressBar = contentView.findViewById(R.id.progressBar);

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

                //change image icons
                Picasso.get().load(profile.getBadge1QuizImage()).into(pProgress1Quiz);
                Picasso.get().load(profile.getBadge5QuizImage()).into(pProgress5Quiz);
                Picasso.get().load(profile.getBadge20QuizImage()).into(pProgress20Quiz);
                Picasso.get().load(profile.getBadge1LanguageImage()).into(pProgress1Language);
                Picasso.get().load(profile.getBadge3LanguageImage()).into(pProgress3Language);
                Picasso.get().load(profile.getBadge5LanguageImage()).into(pProgress5Language);
                Picasso.get().load(profile.getBadgeShareImage()).into(pProgressShare);
                Picasso.get().load(profile.getBadge10LBImage()).into(pProgress10LB);
                Picasso.get().load(profile.getBadge1LBImage()).into(pProgress1LB);

                //retrieve data
                progressNum = profile.getProgress();
                pProgressBar.setProgress(progressNum);
                quizNum = profile.getQuestionCount();
                languageNum = profile.getLanguageCount();

                //badge display criteria
                if (profile.isBadge1Quiz() || quizNum >= 1) {
                    pProgress1Quiz.setVisibility(View.VISIBLE);
                }
                if (profile.isBadge5Quiz() || quizNum >= 5) {
                    pProgress5Quiz.setVisibility(View.VISIBLE);
                }
                if (profile.isBadge20Quiz() || quizNum >= 20) {
                    pProgress20Quiz.setVisibility(View.VISIBLE);
                }
                if (profile.isBadge1Language() || languageNum >= 1) {
                    pProgress1Language.setVisibility(View.VISIBLE);
                }
                if (profile.isBadge3Language() || languageNum >= 3) {
                    pProgress3Language.setVisibility(View.VISIBLE);
                }
                if (profile.isBadge5Language() || languageNum >= 5) {
                    pProgress5Language.setVisibility(View.VISIBLE);
                }
                if (profile.isBadgeShare()) {
                    pProgressShare.setVisibility(View.VISIBLE);
                }
                if (profile.isBadge10LB()) {
                    pProgress10LB.setVisibility(View.VISIBLE);
                }
                if (profile.isBadge1LB()) {
                    pProgress1LB.setVisibility(View.VISIBLE);
                }


                progressDialogHelper.dismiss();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        return contentView;
    }
}
