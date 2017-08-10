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
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void insert(ProfileUser pu) {
        
    }

    @Override
    public void update(ProfileUser pu) {
        
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfileUser getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
