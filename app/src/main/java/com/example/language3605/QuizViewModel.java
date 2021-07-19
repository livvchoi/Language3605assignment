package com.example.language3605;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {

    // data here


    public QuizViewModel() {
        Log.i("QuizViewModel", "QuizViewModel is created");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("QuizViewModel", "View model is destroyed");
    }
}
