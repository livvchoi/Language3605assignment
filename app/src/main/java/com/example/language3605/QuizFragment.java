package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class QuizFragment extends Fragment {
    private Button qNavigateToAnswerQuiz;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_quiz, container, false);

        //code here

        //test switch to answerQuiz frag
        qNavigateToAnswerQuiz = contentView.findViewById(R.id.btNavigateToAnswerQuiz);
        qNavigateToAnswerQuiz.setText("test Answer Quiz frag");
        qNavigateToAnswerQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new AnswerQuizFragment());
                fragmentTransaction.commit();
            }
        });

        return contentView;
    }
}
