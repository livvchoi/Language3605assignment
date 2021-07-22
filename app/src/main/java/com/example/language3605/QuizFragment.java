package com.example.language3605;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

//public class QuizFragment extends Fragment implements SelectQuizAdapter.ItemClickListener, List<SelectQuizData>

public class QuizFragment extends Fragment {

    private static final String TAG = "QuizFragment";

    DatabaseReference quizDatabaseReference;
    DatabaseReference quizDatabaseReference1;

    RecyclerView quizRecyclerView;

    //SelectQuizAdapter adapter;
    //ArrayList<SelectQuizData> list;

    private ArrayList<String> IDList = new ArrayList<>();

    private ArrayList<String> category = new ArrayList<>();

    private ArrayList<String> language = new ArrayList<>();

    private ArrayList<String> quizCategory = new ArrayList<>();

    private ArrayList<String> quizLanguage = new ArrayList<>();

    private ArrayList<String> newCategoryNames = new ArrayList<>();

    private ArrayList<Integer> questionCount = new ArrayList<>();


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


//        list = new ArrayList<>();
//        adapter = new SelectQuizAdapter(list, clickListener);
//        recyclerView.setAdapter(adapter);

        // showing categories in recyclerview
        quizDatabaseReference = FirebaseDatabase.getInstance().getReference();
        ValueEventListener valueEventListener = quizDatabaseReference.child("CategoriesLocale").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String languageName = childSnapshot.child("Language").getValue(String.class);
                    language.add(languageName);

                    String categoryName = childSnapshot.child("Category").getValue(String.class);
                    category.add(categoryName);
                }

                int i = 0;

                while (i < language.size()){
                    if (HomeFragment.item.equals(language.get(i))) {
                        newCategoryNames.add(category.get(i));
                    }
                    i++;
                }
//             SelectQuizAdapter recAdapter = new SelectQuizAdapter(contentView.getContext(), newCategoryNames);
//
//             quizRecyclerView.setAdapter(recAdapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        quizDatabaseReference1 = FirebaseDatabase.getInstance().getReference();
        ValueEventListener valueEventListener1 = quizDatabaseReference1.child("Questions").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String languageName = childSnapshot.child("Language").getValue(String.class);
                    quizLanguage.add(languageName);

                    String categoryName = childSnapshot.child("Category").getValue(String.class);
                    quizCategory.add(categoryName);
                }

                int j = 0;
                int a = 0;
                int b = 0;
                int c = 0;
                int d = 0;
                int e = 0;


                while (j < quizLanguage.size()) {
                    if ((HomeFragment.item.equals(quizLanguage.get(j))) && (quizCategory.get(j).equals("Numbers"))) {
                        a++;
                    } else if ((HomeFragment.item.equals(quizLanguage.get(j))) && (quizCategory.get(j).equals("Greetings/Exclamations/Interjections"))){
                        b++;
                    }else if ((HomeFragment.item.equals(quizLanguage.get(j))) && (quizCategory.get(j).equals("Kinship and People"))){
                        c++;
                    }else if ((HomeFragment.item.equals(quizLanguage.get(j))) && (quizCategory.get(j).equals("Emotions"))) {
                        d++;
                    }
                    else if ((HomeFragment.item.equals(quizLanguage.get(j))) && (quizCategory.get(j).equals("Body Parts"))) {
                        e++;
                    }
                    j++;
                }


                questionCount.add(a);
                questionCount.add(b);
                questionCount.add(c);
                questionCount.add(d);
                questionCount.add(e);


                SelectQuizAdapter recAdapter = new SelectQuizAdapter(contentView.getContext(), newCategoryNames, questionCount);

                quizRecyclerView.setAdapter(recAdapter);



                System.out.println("aaaaaaa:" + a);
                System.out.println("aaaaaaa:" + b);
                System.out.println("aaaaaaa:" + c);
                System.out.println("aaaaaaa:" + d);

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


//             int j = 0;
//             while (j < category.size()){
//                 if (HomeFragment.item.equals(language.get(j)) && category.get(j).equals("Numbers")){
//                     questionCount.add(j);
//                 }else if (HomeFragment.item.equals(language.get(j)) && category.get(j).equals("Greetings/Exclamations/Interjections")){
//                     aquestionCount.add(j);
//
//                 }else if (HomeFragment.item.equals(language.get(j)) && category.get(j).equals("Kinship and People")){
//                     bquestionCount.add(j);
//
//                 }else if (HomeFragment.item.equals(language.get(j)) && category.get(j).equals("Emotions")){
//                         cquestionCount.add(j);
//                 }
//                 i++;
//             }
//             }
//             System.out.println("printing: " + count);



//
//
//         // showing question count in recyclerview
//        ValueEventListener valueEventListener = quizDatabaseReference.child("Questions").addValueEventListener(new ValueEventListener () {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
//                    String categoryNames = childSnapshot.child("Category").getValue(String.class);
//                    category.add(categoryNames);
//
//                    String languages = childSnapshot.child("Language").getValue(String.class);
//                    language.add(languages);
//
//                }
//
//                int i = 0;
//                while(i<category.size()){
//                    if(HomeFragment.item.equals(language.get(i)) && ){
//                        newCategoryNames.add(category.get(i));
//                    }
//                    i++;
//                }
//
//                System.out.println(newCategoryNames);
//
//


//        SelectQuizAdapter recAdapter = new SelectQuizAdapter(contentView.getContext(), newCategoryNames, questionCount);


        return contentView;
    }


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
