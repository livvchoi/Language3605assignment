package com.example.language3605;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizFragment extends Fragment implements SelectQuizAdapter.ItemClickListener{
    //private Button qNavigateToAnswerQuiz;
    private static final String TAG = "quiz fragment";
    private ArrayList<SelectQuizData> list = new ArrayList<>();
    public QuizFragment() {
        // constructor - public
    }

    public static QuizFragment newInstance() {
        QuizFragment fragment = new QuizFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_quiz, container, false);

        //code here
        buildListData();
        initRecyclerView(contentView);
        return contentView;
    }

    private void initRecyclerView (View contentView){
        RecyclerView recyclerView= contentView.findViewById(R.id.rvQuizList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        SelectQuizAdapter adapter = new SelectQuizAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    private void buildListData(){
        list.add(new SelectQuizData("Greetings 1", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Number", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Animals", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Body Parts", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Kinship", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Weather", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Insects", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Emotions", "5 questions", R.drawable.one));
        list.add(new SelectQuizData("Pronouns", "5 questions", R.drawable.one));
    }


    @Override
    public void onItemClick(SelectQuizData selectQuizData) {
        //Fragment fragment = AnswerQuizFragment.newInstance(selectQuizData.getmQuizName());

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        // transaction.replace(R.id.frame_container, fragment, "detail_fragment");

        transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("fragment_quiz"));
        //transaction.add(R.id.fragment_container, new AnswerQuizFragment());
        transaction.replace(R.id.fragment_container, new AnswerQuizFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}


//        //test switch to answerQuiz frag
//        qNavigateToAnswerQuiz = contentView.findViewById(R.id.btNavigateToAnswerQuiz);
//        qNavigateToAnswerQuiz.setText("test Answer Quiz frag");
//        qNavigateToAnswerQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container, new AnswerQuizFragment());
//                fragmentTransaction.commit();
//            }
//        });
