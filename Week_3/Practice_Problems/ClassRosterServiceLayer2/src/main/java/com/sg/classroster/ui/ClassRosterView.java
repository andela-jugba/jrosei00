/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ClassRosterView {
    
     private UserIO io;

    public int printMenuAndSelection() {
        io.print("1. Main Menu");
        io.print("2. List Student IDs");
        io.print("3. Create New Student");
        io.print("4. Remove a Stuent");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    
    public Student getNewStudentInfo() {
        String studentID = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter first name");
        String lastName = io.readString("Please enter last name");
        String cohort = io.readString("Please enter cohort");
        Student currentStudent = new Student(studentID);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("Student successfully created. Please hit enter to continue");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.print(currentStudent.getStudentID() + ": "
                    + currentStudent.getFirstName() + " "
                    + currentStudent.getLastName());
        }
        io.print("Please hit enter to continue.");
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }
    
    public String getStudentIDChoice() {
        return io.readString("Please enter the Student ID");
    }
    
    public void displayStudent(Student student) {
        if(student != null) {
            io.print(student.getStudentID());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Goodbye!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!");
    }
    
    public ClassRosterView(UserIO io) {
        this.io = io;
    }
}
