package com.example.language3605;


import com.google.firebase.database.PropertyName;

import java.util.List;

public class Dictionary {

    @PropertyName("CategoryID")
    private String categoryID;

    @PropertyName("CategoryName")
    private String categoryName;

    @PropertyName("EnglishWord")
    private String englishWord;

    @PropertyName("EntryDate")
    private String entryDate;

    @PropertyName("ID")
    private String id;

    @PropertyName("Image")
    private String image;

    @PropertyName("Language")
    private String language;

    @PropertyName("LanguageID")
    private String languageID;

    @PropertyName("Rating")
    private Integer rating;

    @PropertyName("UserID")
    private String userID;

    @PropertyName("Word")
    private String word;

    @PropertyName("WordID")
    private String wordID;

    public Dictionary(String categoryID, String categoryName, String englishWord, String entryDate, String id, String image, String language, String languageID, Integer rating, String userID, String word, String wordID) {
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

    public Dictionary(){
        System.out.println("default constructor");
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
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

    public String getLanguageID() {
        return languageID;
    }

    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
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

    public String getWordID() {
        return wordID;
    }

    public void setWordID(String wordID) {
        this.wordID = wordID;
    }

    //Get a particular word in the dictionary
    public static Dictionary getDictionaryEntry(List<Dictionary> dictionary, String word) {
        for (final Dictionary entries : dictionary) {
            if (entries.getWord().equals(word)) {
                return entries;
            }
        }
        //return last word in the dictionary if not found
        return dictionary.get(dictionary.size() - 1);
    }

    //get a list of words which match with a category
    public static List<Dictionary> getCategoriesList(List<Dictionary> dictionary, String categoryName) {
        List<Dictionary>wordsInCategoryList = null;
        for (final Dictionary entries : dictionary) {
            if (entries.getCategoryName().equals(categoryName)) {
                wordsInCategoryList.add(entries);
            }
        }
        return wordsInCategoryList;

    }
}

