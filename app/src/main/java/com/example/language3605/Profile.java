package com.example.language3605;

import com.google.firebase.database.PropertyName;

public class Profile {

    @PropertyName("LanguageCount")
    private Integer LanguageCount;

    @PropertyName("Progress")
    private Integer Progress;

    @PropertyName("QuizCompleted")
    private Integer QuizCompleted;

    @PropertyName("QuizCount")
    private Integer QuizCount;


    public Profile() {

    }

    public Profile(Integer languageCount, Integer progress, Integer quizCompleted, Integer quizCount) {
        LanguageCount = languageCount;
        Progress = progress;
        QuizCompleted = quizCompleted;
        QuizCount = quizCount;
    }

    public Integer getLanguageCount() {
        return LanguageCount;
    }

    public void setLanguageCount(Integer languageCount) {
        LanguageCount = languageCount;
    }

    public Integer getProgress() {
        return Progress;
    }

    public void setProgress(Integer progress) {
        Progress = progress;
    }

    public Integer getQuizCompleted() {
        return QuizCompleted;
    }

    public void setQuizCompleted(Integer quizCompleted) {
        QuizCompleted = quizCompleted;
    }

    public Integer getQuizCount() {
        return QuizCount;
    }

    public void setQuizCount(Integer quizCount) {
        QuizCount = quizCount;
    }
}
