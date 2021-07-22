package com.example.language3605;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class QuizViewModel extends ViewModel {
    private MutableLiveData<List<SelectQuizData>> mQuizData;
    private QuizRepository mRepo;

    public void init(){
        if(mQuizData != null){
            return;
        }

        mRepo = QuizRepository.getInstance();
        mQuizData = mRepo.getQuizData();

    }
    public LiveData<List<SelectQuizData>> getQuizData(){
        return mQuizData;
    }

//    private final MutableLiveData<String> quizCategory;
//    private final MutableLiveData<String> quizLanguage;
//    private final MutableLiveData<Float> quizIcon;

//    private ArrayList<String> IDList = new ArrayList<>();
//
//    private ArrayList<String> category = new ArrayList<>();
//
//    private ArrayList<String> language = new ArrayList<>();
//
//    private ArrayList<String> quizCategory = new ArrayList<>();
//
//    private ArrayList<String> quizLanguage = new ArrayList<>();
//
//    private ArrayList<String> newCategoryNames = new ArrayList<>();
//
//    private ArrayList<Integer> questionCount = new ArrayList<>();


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("QuizViewModel", "View model is destroyed");
    }
}
