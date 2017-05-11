/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.mytask.repository;

import com.myapplication.mytask.persistententity.ResponseTimes;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Uzzal
 */
@Repository
@Transactional
public interface ResponseTimeRepo extends CrudRepository<ResponseTimes, Long> {

}
