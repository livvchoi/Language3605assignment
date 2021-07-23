package com.example.language3605;

public class Question {

    private String Answer;
    private String Category;
    private String CategoryID;
    private String ID;
    private String Image;
    private String Language;
    private String LanguageID;
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;
    private String Question;
    private String Type;

    public Question() {

    }

    public Question(String answer, String category, String categoryID, String ID, String image,
                    String language, String languageID, String optionA, String optionB,
                    String optionC, String optionD, String question, String type) {
        Answer = answer;
        Category = category;
        CategoryID = categoryID;
        this.ID = ID;
        Image = image;
        Language = language;
        LanguageID = languageID;
        OptionA = optionA;
        OptionB = optionB;
        OptionC = optionC;
        OptionD = optionD;
        Question = question;
        Type = type;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getLanguageID() {
        return LanguageID;
    }

    public void setLanguageID(String languageID) {
        LanguageID = languageID;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String optionA) {
        OptionA = optionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String optionB) {
        OptionB = optionB;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String optionC) {
        OptionC = optionC;
    }

    public String getOptionD() {
        return OptionD;
    }

    public void setOptionD(String optionD) {
        OptionD = optionD;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Question{" +
                "Answer='" + Answer + '\'' +
                ", Category='" + Category + '\'' +
                ", CategoryID='" + CategoryID + '\'' +
                "ID='" + ID + '\'' +
                "Image='" + Image + '\'' +
                "Language='" + Language + '\'' +
                "LanguageID='" + LanguageID + '\'' +
                "OptionA='" + OptionA + '\'' +
                "OptionB='" + OptionB + '\'' +
                "OptionC='" + OptionC + '\'' +
                "OptionD='" + OptionD + '\'' +
                "Question='" + Question + '\'' +
                "Type='" + Type + '\'' +
                '}';
    }
}
