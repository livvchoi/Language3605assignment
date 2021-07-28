package com.example.language3605;

import com.google.firebase.database.PropertyName;

public class Category {

    @PropertyName("CategoryID")
    private String CategoryId;

    @PropertyName("Category")
    private String Category;

    @PropertyName("Language")
    private String language;

    @PropertyName("Images")
    private String image;

    public Category(String categoryId, String category, String language, String image) {
        CategoryId = categoryId;
        Category = category;
        this.language = language;
        this.image = image;
    }

    public Category(String categoryId, String image, String category) {
        CategoryId = categoryId;
        this.image = image;
        Category = category;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Categorys) {
        Category = Categorys;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String Language) {
        this.language = Language;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
