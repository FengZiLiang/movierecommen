package com.gupt.bigdata.sparkmoviesweb.entity;

public class Personalratings {
    private int userid;
    private int movieid;
    private int rating;
    private String timestamp;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getMovieid() {
        return this.movieid;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating(int rating) {
        return this.rating;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getRating() {
        return this.rating;
    }
}
