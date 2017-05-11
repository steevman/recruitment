/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.mytask.controller;

import com.myapplication.mytask.mappermodels.AlbumItem;
import com.myapplication.mytask.mappermodels.AlbumListObject;
import com.myapplication.mytask.mappermodels.BookVolumes;
import com.myapplication.mytask.response.ResponseModels;
import com.myapplication.mytask.mappermodels.Books;
import com.myapplication.mytask.persistententity.ResponseTimes;
import com.myapplication.mytask.repository.ResponseTimeRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Uzzal
 */
@RestController
@RequestMapping("/api")
@Api("/api")
public class AppController {

    @Value("${search.query.limit:5}")
    private Integer searchLimit;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ResponseTimeRepo responseTimeRepo;

    @Autowired
    private GaugeService gaugeService;

    @RequestMapping(path = "/search/{query}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "List of Search responses", response = ResponseModels.class)
    @ApiResponses(value = {
        @ApiResponse(code = 500, message = "Internal server error"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Unauthorized")
    })
    public List<ResponseModels> search(@PathVariable String query) throws ParseException {

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        BookVolumes bookVolumes = null;
        ResponseTimes responseTimes = new ResponseTimes();

        long startBookTime = System.currentTimeMillis();
        try {
            bookVolumes = restTemplate.getForObject("https://www.googleapis.com/books/v1/volumes?q=" + query + "&maxResults=" + searchLimit, BookVolumes.class);
        } catch (Exception ex) {
            bookVolumes = new BookVolumes();
        }
        long endBookTime = System.currentTimeMillis();

//        Calendar c = Calendar.getInstance();
//        Date date = c.getTime();
//        c.setTime(format.parse(format.format(date)));

        responseTimes.setBookRequestTime(Calendar.getInstance());
        responseTimes.setBookResponseTime(endBookTime - startBookTime);

        AlbumListObject albumListObject = null;
        long startAlbumTime = System.currentTimeMillis();

        try {
            albumListObject
                    = restTemplate.getForObject("https://api.spotify.com/v1/search?q=" + query + "&type=album&limit=" + searchLimit, AlbumListObject.class);
        } catch (Exception ex) {
            albumListObject = new AlbumListObject();
        }
        gaugeService.submit("search.service.time", System.currentTimeMillis());
        long endAlbumTime = System.currentTimeMillis();
        responseTimes.setAlbumRequestTime(Calendar.getInstance());
        responseTimes.setAlbumResponseTime(endAlbumTime - startAlbumTime);

        responseTimeRepo.save(responseTimes);

        List<ResponseModels> responseModelsList = new ArrayList<ResponseModels>();

        for (Books books : bookVolumes.getItems()) {
            ResponseModels responseModels = new ResponseModels();
            responseModels.setType("Book");
            responseModels.setAuthorOrArtist(books.getVolumeInfo().getAuthors());
            responseModels.setTitle(books.getVolumeInfo().getTitle());
            responseModelsList.add(responseModels);
        }

        for (AlbumItem album : albumListObject.getAlbums().getItems()) {
            ResponseModels responseModels = new ResponseModels();
            responseModels.setType("Album");
            responseModels.setAuthorOrArtist(album.getResArtists());
            responseModels.setTitle(album.getName());
            responseModelsList.add(responseModels);
        }
        Collections.sort(responseModelsList);
        return responseModelsList;
    }

    @RequestMapping(path = "/responsetimes", method = RequestMethod.GET, produces = "application/json")
    public List<ResponseTimes> returnResponseTimes() {
        List<ResponseTimes> responseTimesList = (List<ResponseTimes>) responseTimeRepo.findAll();

        return responseTimesList;
    }

}
