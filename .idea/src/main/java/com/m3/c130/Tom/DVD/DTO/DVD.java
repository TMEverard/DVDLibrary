package com.m3.c130.Tom.DVD.DTO;

public class DVD {
    private String title;
    private String releaseDate;
    private String MPAARating;
    private String directorsName;
    private String studio;
    private String userRatingOrNote;


    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }
    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingOrNote() {
        return userRatingOrNote;
    }

    public void setUserRatingOrNote(String userRatingOrNote) {
        this.userRatingOrNote = userRatingOrNote;
    }
}
