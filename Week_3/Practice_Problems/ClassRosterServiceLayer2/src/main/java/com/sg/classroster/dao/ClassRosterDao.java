/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ClassRosterDao {
    
      
    /*
    *Adds the given Student to the roster and associates it with the given
    *student id. If there is already a student associated with the given
    *student id it will return that student object, otherwise it will
    *return null.
    *
    *@param studentID id with which student is to be associated
    *@param student student to be added to the roster
    *@return the Student object previously associated with the given
    *student id if it exists, null otherwise.
    */
    Student addStudent(String studentID, Student student);
    
    /**
     * Returns a String array containing the student ids of all
     * students in the roster
     * 
     * @return String array containing the ids of all the students
     * in the roster
     */
    List<Student> getAllStudents();
    
    /**
     * Returns the student object associated with the given student id.
     * Returns null if no such student exists
     * 
     * @param studentID of the student to retrieve
     * @return the student object associated with the given student id,
     * null if no such student exists
     */
    Student getStudent(String studentID);
    
    /**
     * Removes from the roster the student associated with the given id.
     * Returns the student object that is being removed or null if
     * there is no student associated with the given id
     * 
     * @param studentID id of student to be removed
     * @return Student object that was removed or null if no student
     * was associated with the given student id
     */
    Student removeStudent(String studentID);
}

