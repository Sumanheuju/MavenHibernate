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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
    
    @RequestMapping(value = "profileUser/new", method = RequestMethod.POST)
    public ResponseEntity<Void> addProfileUser(@RequestBody ProfileUser profileUser,UriComponentsBuilder ucb){
        
            profileUserDAO.insert(profileUser);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucb.path("profileUser/{id}").buildAndExpand(profileUser.getProfileUserId()).toUri());
            return new ResponseEntity<>(HttpStatus.CREATED);
        
    }
    
    @RequestMapping(value = "profileUser/{profile_user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileUser> getProfileUser(@PathVariable("profile_user_id") int id){
        
        ProfileUser profileUser = profileUserDAO.getById(id);
        if(profileUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(profileUser, HttpStatus.OK);
        
    }
    
    @RequestMapping(value = "profileUser/edit/{profile_user_id}",
            method = RequestMethod.PUT)
    public ResponseEntity<ProfileUser> updateProfileUser(@PathVariable("profile_user_id") int id,
            @RequestBody ProfileUser proUser){
        
        ProfileUser profileUser = profileUserDAO.getById(id);
        
        if(profileUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        
        profileUser.setName("as");
        profileUser.setAddress("asdasdasd");
        profileUser.setContactNo("asdasdasd");
        profileUser.setLicenseNo("asdasd");
        profileUser.setBloodGroup("äsdasda");
        profileUser.setVehicleNo("adsewfsf");
        profileUser.setEmail("asdasd");
        profileUser.setProfilePicture("äsdasdasd");
        
        profileUserDAO.update(profileUser);
        return new ResponseEntity<>(profileUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "profileUser/delete/{profile_user_id}", method = RequestMethod.DELETE)
    public ResponseEntity<ProfileUser> deleteProfileUser(@PathVariable("profile_user_id") int id){
        ProfileUser profileUser = profileUserDAO.getById(id);
        
        if(profileUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        profileUserDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
