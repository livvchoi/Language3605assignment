package com.example.language3605;


public class Dictionary {

    private Integer categoryID;
    private String categoryName;
    private String englishWord;
    private String entryDate;
    private Integer id;
    private String image;
    private String language;
    private Integer languageID;
    private Double rating;
    private String userID;
    private String word;
    private Integer wordID;

    public Dictionary(Integer categoryID, String categoryName, String englishWord, String entryDate, Integer id, String image, String language, Integer languageID, Double rating, String userID, String word, Integer wordID) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Dictionary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("categoryID");
        sb.append('=');
        sb.append(((this.categoryID == null)?"<null>":this.categoryID));
        sb.append(',');
        sb.append("categoryName");
        sb.append('=');
        sb.append(((this.categoryName == null)?"<null>":this.categoryName));
        sb.append(',');
        sb.append("englishWord");
        sb.append('=');
        sb.append(((this.englishWord == null)?"<null>":this.englishWord));
        sb.append(',');
        sb.append("entryDate");
        sb.append('=');
        sb.append(((this.entryDate == null)?"<null>":this.entryDate));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("languageID");
        sb.append('=');
        sb.append(((this.languageID == null)?"<null>":this.languageID));
        sb.append(',');
        sb.append("rating");
        sb.append('=');
        sb.append(((this.rating == null)?"<null>":this.rating));
        sb.append(',');
        sb.append("userID");
        sb.append('=');
        sb.append(((this.userID == null)?"<null>":this.userID));
        sb.append(',');
        sb.append("word");
        sb.append('=');
        sb.append(((this.word == null)?"<null>":this.word));
        sb.append(',');
        sb.append("wordID");
        sb.append('=');
        sb.append(((this.wordID == null)?"<null>":this.wordID));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}