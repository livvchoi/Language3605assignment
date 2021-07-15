package com.example.language3605;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
import java.util.Arrays;
import java.util.List;

public class AnswerQuizFragment extends Fragment {
    private Button aqTestButton;
    private TextView aqCategory, aqQuestion, aqOptionA, aqOptionB, aqOptionC, aqOptionD;
    private ImageView aqCategoryIcon;

    private static final String TAG = "";
    private List<Question> aqQuestionList;
    private Integer[] aqRanIndexArr;
    private int aqIndex;
    private Question aqQuestionObject;
    private Context aqContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.aqContext = context;
        this.aqIndex = 0;
        this.aqQuestionList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_answer_quiz, container, false);

        //test switch to quizScore frag
        aqTestButton = contentView.findViewById(R.id.answerQuizTestButton);
        aqTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new QuizScoreFragment());
                fragmentTransaction.commit();
            }
        });

        //link with xml
        aqCategory = contentView.findViewById(R.id.tvAnswerQuizCategory);
        aqQuestion = contentView.findViewById(R.id.tvAnswerQuizQuestion);
        aqOptionA = contentView.findViewById(R.id.tvOptionAnswerA);
        aqOptionA = contentView.findViewById(R.id.tvOptionAnswerA);
        aqOptionA = contentView.findViewById(R.id.tvOptionAnswerA);
        aqOptionA = contentView.findViewById(R.id.tvOptionAnswerA);

        aqCategoryIcon = contentView.findViewById(R.id.ivAnswerQuizCategory);

        //link to database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        //retrieve questions (not yet checking question categories)
        reference.child("Questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot questionSnapshot : snapshot.getChildren()) {
                    Question question = questionSnapshot.getValue(Question.class);
                    aqQuestionList.add(question);
                }

                aqRanIndexArr = randomNumber(0, aqQuestionList.size(), 3);
//                Log.i(TAG, "aqRanIndexArr==" + Arrays.toString(aqRanIndexArr));

                aqQuestionObject = aqQuestionList.get(aqRanIndexArr != null ? aqRanIndexArr[aqIndex] : 0);

                setQuestionInfo();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return contentView;
    }

    //set questions into xml from object
    private void setQuestionInfo() {
        aqCategory.setText(aqQuestionObject.getCategory());
        aqQuestion.setText(aqQuestionObject.getQuestion());
//        aqCategoryIcon
        List<String> questionOptions = Arrays.asList(aqQuestionObject.getOptions().split(","));
        aqOptionA.setText(questionOptions.get(0));

        //cannot retrieve second and third option???
//        aqOptionB.setText(questionOptions.get(1));
//        aqOptionC.setText(questionOptions.get(2));
//        aqOptionD.setText(questionOptions.get(3));
    }

    //random Integer array generator
    public static Integer[] randomNumber(int min, int max, int n) {

        if (n > (max - min + 1) || max < min) {
            return null;
        }

        Integer[] result = new Integer[n];

        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < count; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }
}
