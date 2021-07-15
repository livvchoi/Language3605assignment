package com.example.language3605;

public class Question {

    private String Answer;
    private String Category;
    private int CategoryID;
    private int ID;
    private String Image;
    private String Language;
    private int LanguageID;
    private String Options;
    private String Question;
    private String Type;

    public Question() {

    }

    public Question(String answer, String category, int categoryID, int id, String Image, String language, int languageID,
                    String options, String question, String type) {
        this.Answer = answer;
        this.Category = category;
        this.CategoryID = categoryID;
        this.ID = id;
        this.Language = language;
        this.LanguageID = languageID;
        this.Options = options;
        this.Question = question;
        this.Type = type;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        this.Answer = answer;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public int getLanguageID() {
        return LanguageID;
    }

    public void setLanguageID(int languageID) {
        this.LanguageID = languageID;
    }

    public String getOptions() {
        return Options;
    }

    public void setOptions(String Options) {
        this.Options = Options;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
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
                "Options='" + Options + '\'' +
                "Question='" + Question + '\'' +
                "Type='" + Type + '\'' +
                '}';
    }
}
