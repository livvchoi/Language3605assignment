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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Picasso;

public class QuizScoreFragment extends Fragment {
    private TextView tvRetry, tvChangeQuiz, tvScore, tvCategory, tvTotalTime;
    private ImageView ivQuizScoreCategoryIcon;
    private MyViewModel myViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_quiz_score, container, false);

        //code here
        tvRetry = contentView.findViewById(R.id.tvQuizScoreRetry);
        tvChangeQuiz = contentView.findViewById(R.id.tvQuizScoreTakeAnotherQuiz);
        tvScore = contentView.findViewById(R.id.tvQuizScoreScore);
        tvTotalTime = contentView.findViewById(R.id.tvQuizScoreTotalTime);
        tvCategory = contentView.findViewById(R.id.tvQuizScoreCategory);

        ivQuizScoreCategoryIcon = contentView.findViewById(R.id.ivQuizScoreCategory);

        tvRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String testCategoryName = "Body Parts";
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new AnswerQuizFragment(testCategoryName));
                fragmentTransaction.commit();
            }
        });

        tvChangeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new QuizFragment());
                fragmentTransaction.commit();
            }
        });

        myViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        myViewModel.getQuizScoreCorrect().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvScore.setText("Score: " + s + "/3");
            }
        });
        myViewModel.getQuizScoreTotalTime().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvTotalTime.setText("Total Time: " + s + " sec");
            }
        });
        myViewModel.getQuizScoreCategory().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvCategory.setText(s);
            }
        });
        myViewModel.getQuizScoreCategoryIcon().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Picasso.get().load(s).into(ivQuizScoreCategoryIcon);
            }
        });

        return contentView;
    }
}
