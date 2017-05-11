/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.mytask.persistententity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Uzzal
 */
@Entity
@Table(name = "RESPONSETIMES")
public class ResponseTimes {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "BOOKRESPONSETIME")
    private Long bookResponseTime;
    @Column(name = "ALBUMRESPONSETIME")
    private Long albumResponseTime;
    // request time
    @Column(name = "BOOKREQUESTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar bookRequestTime;

    @Column(name = "ALBUMREQUESTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar albumRequestTime;

    public void setId(long id) {
        this.id = id;
    }

    public Long getBookResponseTime() {
        return bookResponseTime;
    }

    public void setBookResponseTime(Long bookResponseTime) {
        this.bookResponseTime = bookResponseTime;
    }

    public Long getAlbumResponseTime() {
        return albumResponseTime;
    }

    public void setAlbumResponseTime(Long albumResponseTime) {
        this.albumResponseTime = albumResponseTime;
    }

    public Calendar getBookRequestTime() {
        return bookRequestTime;
    }

    public void setBookRequestTime(Calendar bookRequestTime) {
        this.bookRequestTime = bookRequestTime;
    }

    public Calendar getAlbumRequestTime() {
        return albumRequestTime;
    }

    public void setAlbumRequestTime(Calendar albumRequestTime) {
        this.albumRequestTime = albumRequestTime;
    }

}
