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
public class Albums {
    private String href;
    private List<AlbumItem> items = new ArrayList<>();
    
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<AlbumItem> getItems() {
        return items;
    }

    public void setItems(List<AlbumItem> items) {
        this.items = items;
    }
    
}
