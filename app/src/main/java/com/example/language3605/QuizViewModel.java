package com.example.language3605;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {

    public QuizViewModel() {
        Log.i("QuizViewModel", "QuizViewModel is created");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
