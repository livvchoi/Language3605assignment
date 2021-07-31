package com.example.language3605;

public class Profile {

    private int LanguageCount;
    private int Progress;
    private int QuestionCount;
    private int QuizProgress;


    public Profile() {

    }

    public Profile(int languageCount, int progress, int questionCount, int quizProgress) {
        LanguageCount = languageCount;
        Progress = progress;
        QuestionCount = questionCount;
        QuizProgress = quizProgress;
    }

    public int getLanguageCount() {
        return LanguageCount;
    }

    public void setLanguageCount(int languageCount) {
        LanguageCount = languageCount;
    }

    public int getProgress() {
        return Progress;
    }

    public void setProgress(int progress) {
        Progress = progress;
    }

    public int getQuestionCount() {
        return QuestionCount;
    }

    public void setQuestionCount(int questionCount) {
        QuestionCount = questionCount;
    }

    public int getQuizProgress() {
        return QuizProgress;
    }

    public void setQuizProgress(int quizProgress) {
        QuizProgress = quizProgress;
    }



}
