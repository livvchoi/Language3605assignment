package com.example.language3605;

import com.google.firebase.database.PropertyName;

import java.util.List;

public class Story {
    @PropertyName("ID")
    private String ID;

    @PropertyName("Country")
    private String country;

    @PropertyName("Stories")
    private String stories;

    @PropertyName("Source")
    private String source;

    @PropertyName("Title")
    private String title;

    public Story(String ID, String country, String stories, String source, String title) {
        this.ID = ID;
        this.country = country;
        this.stories = stories;
        this.source = source;
        this.title = title;
    }

    public Story() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStories() {
        return stories;
    }

    public void setStories(String stories) {
        this.stories = stories;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Get a particular story
    public static Story getStoryEntry(List<Story> storiesList, String id) {
        for (final Story entries : storiesList) {
            if (entries.getID().equals(id)) {
                return entries;
            }
        }
        //return last word in the dictionary if not found
        return storiesList.get(storiesList.size() - 1);
    }
}
