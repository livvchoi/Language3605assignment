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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

//public class QuizFragment extends Fragment implements SelectQuizAdapter.ItemClickListener, List<SelectQuizData>

public class QuizFragment extends Fragment {

    private static final String TAG = "quiz fragment";

    RecyclerView quizRecyclerView;
    DatabaseReference quizDatabaseReference;
    //SelectQuizAdapter adapter;
    //ArrayList<SelectQuizData> list;

    private ArrayList<String> IDList = new ArrayList<>();
    private ArrayList<String> CategoryNames = new ArrayList<>();
    private ArrayList<String> language = new ArrayList<>();

    private ArrayList<String> newCategoryNames = new ArrayList<>();
//    private ArrayList<String> aCategories = new ArrayList<>();
//    private ArrayList<String> bCategories = new ArrayList<>();
//    private SelectQuizAdapter.ItemClickListener clickListener;

    //private QuizViewModel quizViewModel;

//    public QuizFragment() {
//        // constructor - public
//    }
//
//    public static QuizFragment newInstance() {
//        QuizFragment fragment = new QuizFragment();
//        return fragment;
//    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//        }
//
//        //initialize QuizViewModel
//        //quizViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_quiz, container, false);

        //code here
        quizRecyclerView = contentView.findViewById(R.id.rvQuizList);
        quizRecyclerView.setHasFixedSize(true);
        quizRecyclerView.setLayoutManager(new LinearLayoutManager(contentView.getContext()));

        quizDatabaseReference = FirebaseDatabase.getInstance().getReference();

//        list = new ArrayList<>();
//        adapter = new SelectQuizAdapter(list, clickListener);
//        recyclerView.setAdapter(adapter);

        String languageClicked = HomeFragment.item;

        ValueEventListener valueEventListener = quizDatabaseReference.child("Questions").addValueEventListener(new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
//                    String ID = childSnapshot.child("ID").getValue(String.class);
//                    IDList.add(ID);

                    String categoryNames = childSnapshot.child("Category").getValue(String.class);
                    CategoryNames.add(categoryNames);

                    String languages = childSnapshot.child("Language").getValue(String.class);
                    language.add(languages);


                }

                int i = 0;
                while(i<CategoryNames.size()){
                    if(languageClicked == language.get(i)){
                        newCategoryNames.add(CategoryNames.get(i));
                    }
                    i++;
                }


                SelectQuizAdapter adapter = new SelectQuizAdapter(contentView.getContext(), newCategoryNames);
                quizRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        return contentView;
        }


                //////////////////////
//        quizDatabaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    SelectQuizData data = dataSnapshot.getValue(SelectQuizData.class);
//                    list.add(data);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull @NotNull DatabaseError error) {
//
//            }
//        });



//    private void buildListData(){
//        list.add(new SelectQuizData("Greetings 1", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Number", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Animals", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Body Parts", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Kinship", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Weather", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Insects", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Emotions", "5 questions", R.drawable.one));
//        list.add(new SelectQuizData("Pronouns", "5 questions", R.drawable.one));
//    }


//    @Override
//    public void onItemClick(SelectQuizData selectQuizData) {
//        //Fragment fragment = AnswerQuizFragment.newInstance(selectQuizData.getmQuizName());
//
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        // transaction.replace(R.id.frame_container, fragment, "detail_fragment");
//
//        transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("fragment_quiz"));
//        //transaction.add(R.id.fragment_container, new AnswerQuizFragment());
//        transaction.replace(R.id.fragment_container, new AnswerQuizFragment());
//        transaction.addToBackStack(null);
//        transaction.commit();
//
//    }

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
