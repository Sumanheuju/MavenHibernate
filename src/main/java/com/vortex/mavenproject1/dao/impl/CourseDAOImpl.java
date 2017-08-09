/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.dao.impl;

import com.vortex.mavenproject1.dao.CourseDAO;
import com.vortex.mavenproject1.entity.Course;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sumanheuju
 */
@Repository(value = "courseDAO")
public class CourseDAOImpl implements CourseDAO{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    
    @Override
    public List<Course> getAll() {
        session = sessionFactory.openSession();
        List<Course> courseList = session.createQuery("Select c from Course c").list();
        session.close();
        return courseList;
    }
    
}
