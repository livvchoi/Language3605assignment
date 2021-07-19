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

}
