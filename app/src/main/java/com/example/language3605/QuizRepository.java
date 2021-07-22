package com.example.language3605;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository {

    private static QuizRepository instance;
    private ArrayList<SelectQuizData> dataSet = new ArrayList<>();

    public static QuizRepository getInstance(){
        if(instance == null){
            instance = new QuizRepository();
        }
        return instance;
    }

    //get data from the source
    public MutableLiveData<List<SelectQuizData>> getQuizData(){
        setQuizData();

        MutableLiveData<List<SelectQuizData>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;

    }

    private void setQuizData(){
        dataSet.add(new SelectQuizData("1", "numbers"));
    }
}
