package com.example.revistasacademidas20.Modelo;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private String issue_id;
    private String volume;
    private String number;
    private String year;
    private String date_published;
    private String title;
    private String doi;
    private  String cover;


    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    private String UrlImagen;

    public Revista(JSONObject a) throws JSONException{
        issue_id= a.getString("issue_id").toString();
        volume=a.getString("volume").toString();
        number=a.getString("number").toString();
        year=a.getString("year").toString();
        date_published=a.getString("date_published").toString();
        title=a.getString("title").toString();
        doi=a.getString("doi").toString();
        cover=a.getString("cover").toString();
        UrlImagen=a.getString("cover").toString();
    }

    public static ArrayList<Revista> JsonObjectsBuild(JSONArray date) throws JSONException{
        ArrayList<Revista> revistas = new ArrayList<>();

        for(int i= 0; i<date.length();i++){
            revistas.add(new Revista(date.getJSONObject(i)));
        }
        return revistas;

    }

}
