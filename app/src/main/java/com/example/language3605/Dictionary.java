package com.example.language3605;


import java.util.List;

public class Dictionary {

    private Integer categoryID;
    private String categoryName;
    private String englishWord;
    private String entryDate;
    private String id;
    private String image;
    private String language;
    private Integer languageID;
    private Double rating;
    private String userID;
    private String word;
    private Integer wordID;

    public Dictionary(Integer categoryID, String categoryName, String englishWord, String entryDate, String id, String image, String language, Integer languageID, Double rating, String userID, String word, Integer wordID) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.englishWord = englishWord;
        this.entryDate = entryDate;
        this.id = id;
        this.image = image;
        this.language = language;
        this.languageID = languageID;
        this.rating = rating;
        this.userID = userID;
        this.word = word;
        this.wordID = wordID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getWordID() {
        return wordID;
    }

    public void setWordID(Integer wordID) {
        this.wordID = wordID;
    }

    //after pulling the list, get the particular word in the dictionary
    public static Dictionary getDictionaryEntry (List<Dictionary> dictionary, String word){
        for (final Dictionary entries: dictionary){
            if (entries.getWord().equals(word)){
                return entries;
            }
        }
        //return last word in the dictionary if not found
        return dictionary.get(dictionary.size()-1);
    }

}