/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.mytask.response;

import java.util.List;

/**
 *
 * @author Uzzal
 */
public class ResponseModels implements Comparable<ResponseModels>{
    
    private String type;
    private String title;
    private List<String> authorOrArtist;

    public ResponseModels() {
    }

    public ResponseModels(String type, String title, List<String> authorOrArtist) {
        this.type = type;
        this.title = title;
        this.authorOrArtist = authorOrArtist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthorOrArtist() {
        return authorOrArtist;
    }

    public void setAuthorOrArtist(List<String> authorOrArtist) {
        this.authorOrArtist = authorOrArtist;
    }

    @Override
    public String toString() {
        return "ResponseModels{" + "type=" + type + ", title=" + title + ", authorOrArtist=" + authorOrArtist + '}';
    }        

    @Override
    public int compareTo(ResponseModels o) {
        return this.getTitle().compareTo(o.getTitle());
    }
    
}
