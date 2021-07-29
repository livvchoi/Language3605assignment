package com.example.language3605;

import com.google.firebase.database.PropertyName;

import java.util.List;

public class Language {
    @PropertyName("ID")
    private String id;

    @PropertyName("Name")
    private String name;

    @PropertyName("Speakers")
    private Integer speakers;

    @PropertyName("Country")
    private String country;

    @PropertyName("StateTerritory")
    private String stateTerritory;

   @PropertyName("Description")
   private String description;

    public Language() {
    }

    public Language(String id, String name, Integer speakers, String country, String stateTerritory, String description) {
        this.id = id;
        this.name = name;
        this.speakers = speakers;
        this.country = country;
        this.stateTerritory = stateTerritory;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Integer speakers) {
        this.speakers = speakers;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateTerritory() {
        return stateTerritory;
    }

    public void setStateTerritory(String stateTerritory) {
        this.stateTerritory = stateTerritory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Language getLanguage (List<Language> languageList, String langClicked){
        for (final Language entries: languageList){
            if(entries.getName().equals(langClicked)){
                return entries;
            }
        }
       return languageList.get(languageList.size()-1);
    }
}
