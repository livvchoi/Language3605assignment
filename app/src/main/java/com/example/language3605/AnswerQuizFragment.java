package com.example.language3605;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
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

    private ProgressDialogHelper progressDialogHelper;

    private CountDownTimer aqCountDownTimer;
    private static final long TOTAL_TIME = 15 * 1000;
    private long aqTimeTaken;
    private long aqTotalTimeTaken;
    private int aqCorrectNum;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.aqContext = context;
        this.aqIndex = 0;
        this.aqQuestionList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
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
        aqOptionB = contentView.findViewById(R.id.tvOptionAnswerB);
        aqOptionC = contentView.findViewById(R.id.tvOptionAnswerC);
        aqOptionD = contentView.findViewById(R.id.tvOptionAnswerD);

        aqCategoryIcon = contentView.findViewById(R.id.ivAnswerQuizCategory);

        //loading prompt
        this.progressDialogHelper = new ProgressDialogHelper(getContext());

        //link to database
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        //show loading prompt
        progressDialogHelper.show("loading", "load question data...");

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
                progressDialogHelper.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        aqOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerResult(TextUtils.equals(aqQuestionObject.getAnswer(),
                        aqOptionA.getText().toString().trim()),
                        aqOptionA.getText().toString().trim(),0);
            }
        });
        aqOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerResult(TextUtils.equals(aqQuestionObject.getAnswer(),
                        aqOptionB.getText().toString().trim()),
                        aqOptionB.getText().toString().trim(),1);
            }
        });
        aqOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerResult(TextUtils.equals(aqQuestionObject.getAnswer(),
                        aqOptionC.getText().toString().trim()),
                        aqOptionC.getText().toString().trim(),2);
            }
        });
        aqOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerResult(TextUtils.equals(aqQuestionObject.getAnswer(),
                        aqOptionD.getText().toString().trim()),
                        aqOptionD.getText().toString().trim(),3);
            }
        });

        return contentView;
    }

    //set questions into xml from object
    private void setQuestionInfo() {
        aqCategory.setText(aqQuestionObject.getCategory());
        aqQuestion.setText(aqQuestionObject.getQuestion());
//        aqCategoryIcon
        aqOptionA.setText(aqQuestionObject.getOptionA());
        aqOptionB.setText(aqQuestionObject.getOptionB());
        aqOptionC.setText(aqQuestionObject.getOptionC());
        aqOptionD.setText(aqQuestionObject.getOptionD());

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

    //correct/incorrect answer prompt
    private void showAnswerResult(boolean isSuccessful, String userAnswer, int answerIndex) {
        if (isSuccessful) aqCorrectNum++;
        View dialogView = LayoutInflater.from(aqContext).inflate(R.layout.dialogue_question_result, null);
        TextView tvCorrect = dialogView.findViewById(R.id.tvDialogueCorrect);
        TextView tvTimeTaken = dialogView.findViewById(R.id.tvDialogueTimeTaken);
        TextView tvUserAnswer = dialogView.findViewById(R.id.tvDialogueUserAnswer);
        TextView tvCorrectAnswer = dialogView.findViewById(R.id.tvDialogueCorrectAnswer);
        TextView tvNext = dialogView.findViewById(R.id.tvNext);
        tvCorrect.setText(isSuccessful ? "Correct" : "Incorrect");
        tvCorrect.setCompoundDrawablesWithIntrinsicBounds(null,null,
                ContextCompat.getDrawable(aqContext, isSuccessful ? R.mipmap.ic_correct : R.mipmap.ic_error), null);
//        tvTimeTaken.setText("Time taken: " + );
        tvUserAnswer.setText("Your Answer: " + userAnswer.toLowerCase());
        tvCorrectAnswer.setText("Correct Answer: " + aqQuestionObject.getAnswer().toLowerCase());
        tvNext.setText(aqIndex < 2 ? "Next" : "View Results");
        AlertDialog dialog = new AlertDialog.Builder(aqContext).setView(dialogView).create();
        tvNext.setOnClickListener(view1 -> {
            if (aqIndex == 2) {
                //pass data to quiz result fragment

            } else if (aqIndex < 2) {
                aqIndex++;
                aqQuestionObject = aqQuestionList.get(aqRanIndexArr[aqIndex]);
                setQuestionInfo();

            }
            dialog.dismiss();
        });
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private String getAnswerNum(int index) {
        switch (index) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
        }
        return "A";
    }
}
