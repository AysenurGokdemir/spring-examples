package com.aysenur.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
@Document //bu sekilde bunun bir collectiona karşılık gelecegini soylemiş olduk
public class User {
    @Id //user collectionının primary key inin Id oldugunu belirtiyoruz
    private String id;
    private String name;
    private String lastName;
    //key value seklinde deger tutar
    private HashMap properties;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public HashMap getProperties() {
        return properties;
    }

    public void setProperties(HashMap properties) {
        this.properties = properties;
    }
}
