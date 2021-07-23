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

    @PropertyName("Description")
    private String description;

    @PropertyName("StateTerritory")
    private String stateTerritory;

    @PropertyName("Country")
    private String country;

    private List<String> categories;

    public Language(String id, String name, Integer speakers, String description, String stateTerritory, String country) {
        this.id = id;
        this.name = name;
        this.speakers = speakers;
        this.description = description;
        this.stateTerritory = stateTerritory;
        this.country = country;
    }


}
