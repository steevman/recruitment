/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.mytask.mappermodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Uzzal
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookVolumes {

    private String kind;
    private int totalItems;
    private List<Books> items;

    public BookVolumes() {
        this.items = new ArrayList<>();
    }

    public BookVolumes(String kind, int totalItems, List<Books> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Books> getItems() {
        return items;
    }

    public void setItems(List<Books> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "BookVolumes{" + "kind=" + kind + ", totalItems=" + totalItems + ", items=" + items + '}';
    }

}
