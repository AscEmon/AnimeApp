package com.example.animeapp.Model;


public class Anime {

    private String name;
    private String description;
    private String rating;
    private Integer episode;
    private String categorie;
    private String studio;
    private String img;


    public Anime() {
    }


    public Anime(String name, String description, String rating, Integer episode, String categorie, String studio, String img) {
        super();
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.episode = episode;
        this.categorie = categorie;
        this.studio = studio;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}