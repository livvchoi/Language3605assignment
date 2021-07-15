package com.example.language3605;

public class SelectQuizData {
    private String mQuizName;
    private String mNumQuestion;
    private Integer mQuizIcon;

    public SelectQuizData(String mQuizName, String mNumQuestion, Integer mQuizIcon) {
        this.mQuizName = mQuizName;
        this.mNumQuestion = mNumQuestion;
        this.mQuizIcon = mQuizIcon;
    }

    public String getmQuizName() {
        return mQuizName;
    }

    public void setmQuizName(String mQuizName) {
        this.mQuizName = mQuizName;
    }

    public String getmNumQuestion() {
        return mNumQuestion;
    }

    public void setmNumQuestion(String mNumQuestion) {
        this.mNumQuestion = mNumQuestion;
    }

    public Integer getmQuizIcon() {
        return mQuizIcon;
    }

    public void setmQuizIcon(Integer mQuizIcon) {
        this.mQuizIcon = mQuizIcon;
    }
}
