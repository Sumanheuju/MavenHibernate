/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vortex.mavenproject1.dao;

import com.vortex.mavenproject1.entity.Course;
import java.util.List;

/**
 *
 * @author sumanheuju
 */
public interface CourseDAO {
    List<Course> getAll();
    
}
