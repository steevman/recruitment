/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.mytask.mappermodels;

import java.util.List;

/**
 *
 * @author Uzzal
 */
public class VolumeInfo {

    private String title;
    private List<String> authors;

    public VolumeInfo() {
    }

    public VolumeInfo(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "VolumeInfo{" + "title=" + title + ", authors=" + authors + '}';
    }
        
}
