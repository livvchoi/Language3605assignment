package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StartQuizFragment extends Fragment {

    String categoryName;
    Integer questionCount;

    public StartQuizFragment(String categoryName, Integer questionCount) {
        this.categoryName = categoryName;
        this.questionCount = questionCount;

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View contentView = inflater.inflate(R.layout.fragment_start_quiz, container, false);

        //code here
//        TextView mQuizDesc = contentView.findViewById(R.id.tv_time_limit);
        TextView categoryName = contentView.findViewById(R.id.tv_category_name);
        TextView questionCount = contentView.findViewById(R.id.tv_startQuiz_num_question);

        //mQuizDesc.setText(mQuizDesc);
        categoryName.setText(this.categoryName);
        questionCount.setText(this.questionCount + "");

        return contentView;
    }
}