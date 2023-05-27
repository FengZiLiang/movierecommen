package com.gupt.bigdata.sparkmoviesweb.entity;

import java.util.Date;

public class Movie {
    private int movieid;
    private String moviename;
    private Date releasetime;
    private String director;
    private String leadactors;
    private String picture;
    private double averating;
    private int numrating;
    private String description;
    private String typelist;

    public void setMovieid(int movieid){
        this.movieid=movieid;
    }
    public int getMovieid(){
        return this.movieid;
    }

    public void setMoviename(String moviename){
        this.moviename=moviename;
    }
    public String getMoviename(){
        return this.moviename;
    }

    public void setReleasetime(Date releasetime){
        this.releasetime=releasetime;
    }
    public Date getReleasetime(){
        return this.releasetime;
    }

    public void setDirector(String director){
        this.director=director;
    }
    public String getDirector(){
        return this.director;
    }

    public void setLeadactors(String leadactors){
        this.leadactors=leadactors;
    }
    public String getLeadactors(){
        return this.leadactors;
    }

    public void setPicture(String picture){
        this.picture=picture;
    }
    public String getPicture(){
        return this.picture;
    }

    public void setAverating(double averating){
        this.averating=averating;
    }
    public double getAverating(){
        return this.averating;
    }

    public void setNumrating(int numrating){
        this.numrating=numrating;
    }
    public int getNumrating(){
        return this.numrating;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return this.description;
    }

    public void setTypelist(String typelist){
        this.typelist=typelist;
    }
    public String getTypelist(){
        return this.typelist;
    }

}
