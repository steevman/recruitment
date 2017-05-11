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
public class AlbumListObject {
    private Albums albums;

    public AlbumListObject() {
        this.albums = new Albums();
    }

    public Albums getAlbums() {
        return albums;
    }

    public void setAlbums(Albums albums) {
        this.albums = albums;
    }
}
