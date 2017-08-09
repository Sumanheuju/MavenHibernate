/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.dao.impl;

import com.vortex.mavenproject1.dao.ProfileUserDAO;
import com.vortex.mavenproject1.entity.ProfileUser;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sumanheuju
 */
@Repository(value = "profileUserDAO")
public class ProfileUserDAOImpl implements ProfileUserDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    @Override
    public List<ProfileUser> getAll() {
        session = sessionFactory.openSession();
        List<ProfileUser> profileUsers = session.createQuery("Select pu from ProfileUser pu").list();
        session.close();
        return profileUsers;
    }
    
}
