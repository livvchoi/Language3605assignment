package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.picasso.Picasso;

public class StartQuizFragment extends Fragment {

    String categoryName;
    Integer questionCount;
    String quizIcon;
    Button btnStartQuiz;

    public StartQuizFragment(String categoryName, Integer questionCount, String quizIcon) {
        this.categoryName = categoryName;
        this.questionCount = questionCount;
        this.quizIcon = quizIcon;

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View contentView = inflater.inflate(R.layout.fragment_start_quiz, container, false);

        //code here
//        TextView mQuizDesc = contentView.findViewById(R.id.tv_time_limit);
        TextView categoryName = contentView.findViewById(R.id.tv_category_name);
        TextView questionCount = contentView.findViewById(R.id.tv_startQuiz_num_question);
        ImageView quizIcon = contentView.findViewById(R.id.iv_quiz_icon_2);
        btnStartQuiz = contentView.findViewById(R.id.btn_start_quiz);

        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                AnswerQuizFragment goFragment = new AnswerQuizFragment(categoryName.getText().toString());
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, goFragment).addToBackStack(null).commit();
            }
        });

        //mQuizDesc.setText(mQuizDesc);
        categoryName.setText(this.categoryName);
        questionCount.setText(this.questionCount + "");
        Picasso.get().load(this.quizIcon).into(quizIcon);

        return contentView;
    }
}