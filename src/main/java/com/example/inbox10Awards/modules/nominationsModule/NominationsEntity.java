package com.example.inbox10Awards.modules.nominationsModule;

import jdk.jfr.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NominationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String genre;
    private String Category;
    private String nominationType;
    private String nominatorEmail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getNominationType() {
        return nominationType;
    }

    public void setNominationType(String nominationType) {
        this.nominationType = nominationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNominatorEmail() {
        return nominatorEmail;
    }

    public void setNominatorEmail(String nominatorEmail) {
        this.nominatorEmail = nominatorEmail;
    }
}
