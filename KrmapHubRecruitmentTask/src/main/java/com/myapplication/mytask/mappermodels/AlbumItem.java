/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.mytask.mappermodels;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Uzzal
 */
public class AlbumItem {
    private String album_type;
    private List<Artist> artists;
    private List<String> resArtists = new ArrayList<>();
    private String name;
    private String type;

    public String getAlbum_type() {
        return album_type;
    }

    public void setAlbum_type(String album_type) {
        this.album_type = album_type;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
        for (Artist artist : this.artists) {
            this.resArtists.add(artist.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getResArtists() {
        return resArtists;
    }
}
