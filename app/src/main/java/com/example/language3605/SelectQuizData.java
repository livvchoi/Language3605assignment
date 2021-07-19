package com.example.language3605;

public class SelectQuizData {
    static String ID;
    static String Name;

    public SelectQuizData(String ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public static String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }






    //    private String mQuizName;
//    private String mNumQuestion;
//    private Integer mQuizIcon;
//
//    public SelectQuizData(String mQuizName, String mNumQuestion, Integer mQuizIcon) {
//        this.mQuizName = mQuizName;
//        this.mNumQuestion = mNumQuestion;
//        this.mQuizIcon = mQuizIcon;
//    }
//
//    public String getmQuizName() {
//        return mQuizName;
//    }
//
//    public void setmQuizName(String mQuizName) {
//        this.mQuizName = mQuizName;
//    }
//
//    public String getmNumQuestion() {
//        return mNumQuestion;
//    }
//
//    public void setmNumQuestion(String mNumQuestion) {
//        this.mNumQuestion = mNumQuestion;
//    }
//
//    public Integer getmQuizIcon() {
//        return mQuizIcon;
//    }
//
//    public void setmQuizIcon(Integer mQuizIcon) {
//        this.mQuizIcon = mQuizIcon;
//    }
}
