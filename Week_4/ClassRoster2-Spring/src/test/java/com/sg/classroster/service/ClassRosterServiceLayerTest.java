/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class ClassRosterServiceLayerTest {

    ClassRosterServiceLayer service;

    public ClassRosterServiceLayerTest() {
        //wire the Service Layer with stub implementations of the Dao and auditdao
        //ClassRosterDao dao = new ClassRosterDaoStubImpl();
        //ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
        //service = new ClassRosterServiceLayerImpl(dao, auditDao);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
        //System.out.println("createStudent");
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java - May - 2017");
        service.createStudent(student);
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java - May - 2017");
        try {
            service.createStudent(student);
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        System.out.println("getStudent");
        String studentId = "";
        ClassRosterServiceLayer instance = new ClassRosterServiceLayerImpl();
        Student expResult = null;
        Student result = instance.getStudent(studentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        System.out.println("removeStudent");
        String studentId = "";
        ClassRosterServiceLayer instance = new ClassRosterServiceLayerImpl();
        Student expResult = null;
        Student result = instance.removeStudent(studentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

        public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        }

        public List<Student> getAllStudents() throws ClassRosterPersistenceException {
            return null;
        }

        public Student getStudent(String studentId) throws ClassRosterPersistenceException {
            return null;
        }

        public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
            return null;
        }
    }

}
