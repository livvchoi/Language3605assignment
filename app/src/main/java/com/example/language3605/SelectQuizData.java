package com.example.language3605;

public class SelectQuizData {
    static String ID;
    static String Name;


    public SelectQuizData(String ID, String name) {
        SelectQuizData.ID = ID;
        Name = name;
    }

    public static String getID() {
        return ID;
    }

    public void setID(String ID) {
        SelectQuizData.ID = ID;
    }

    public static String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
