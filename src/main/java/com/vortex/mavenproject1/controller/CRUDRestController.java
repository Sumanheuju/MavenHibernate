/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.controller;

import com.vortex.mavenproject1.dao.ProfileUserDAO;
import com.vortex.mavenproject1.entity.ProfileUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sumanheuju
 */
@RestController
@RequestMapping(value = "/api/")
public class CRUDRestController {
    
    @Autowired
    private ProfileUserDAO profileUserDAO;
    
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity<List<ProfileUser>> listAllProfileUsers(){
        List<ProfileUser> profileUsers = profileUserDAO.getAll();
        if(profileUsers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(profileUsers, HttpStatus.OK);
    }
    
}
