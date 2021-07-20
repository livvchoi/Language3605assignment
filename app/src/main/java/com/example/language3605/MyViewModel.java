package com.example.language3605;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private final SavedStateHandle state;
    private final MutableLiveData<String> quizScoreCorrect;
    private final MutableLiveData<String> quizScoreTotalTime;
    private final MutableLiveData<String> quizScoreCategory;

    public MyViewModel(SavedStateHandle state) {
        this.state = state;

        quizScoreCorrect = state.getLiveData("1");
        quizScoreTotalTime = state.getLiveData("2");
        quizScoreCategory = state.getLiveData("3");
    }

    public void sendQuizScoreCorrect(String msg) {
        quizScoreCorrect.setValue(msg);
    }

    public LiveData<String> getQuizScoreCorrect() {
        return quizScoreCorrect;
    }

    public void sendQuizScoreTotalTime(String msg) {
        quizScoreTotalTime.setValue(msg);
    }

    public LiveData<String> getQuizScoreTotalTime() {
        return quizScoreTotalTime;
    }
    public void sendQuizScoreCategory(String msg) {
        quizScoreCategory.setValue(msg);
    }

    public LiveData<String> getQuizScoreCategory() {
        return quizScoreCategory;
    }
}
