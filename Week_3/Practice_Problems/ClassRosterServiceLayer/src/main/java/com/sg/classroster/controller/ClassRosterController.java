/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import com.sg.classroster.ui.ClassRosterView;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ClassRosterController {

    ClassRosterView view;
    ClassRosterDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndSelection();
    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentID(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentID = view.getStudentIDChoice();
        Student student = dao.getStudent(studentID);
        view.displayStudent(student);
    }

    private void removeStudent() {
        view.displayRemoveStudentBanner();
        String studentID = view.getStudentIDChoice();
        dao.removeStudent(studentID);
        view.displayRemoveSuccessBanner();
    }

    public void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    public void exitMessage() {
        view.displayExitBanner();
    }
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }
}