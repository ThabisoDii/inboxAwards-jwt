package com.example.inbox10Awards.modules.nominationsModule;

public class NominateArtistDTO {
    private String name;
    private String category;
    private String nominationType;//single,best new comer,or album
    private String genre;
    private String nominator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNominationType() {
        return nominationType;
    }

    public void setNominationType(String nominationType) {
        this.nominationType = nominationType;
    }

    public String getNominator() {
        return nominator;
    }

    public void setNominator(String nominator) {
        this.nominator = nominator;
    }
}
