/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neldo
 */
public class GradesTest {
    
    public GradesTest() {
    }

    /**
     * Test of print method, of class Grades.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        
        Grades instance = new Grades(50);
        
        String expResult = "F";
        String result = instance.print();
        assertEquals(expResult, result);
        
        expResult = "D";
        instance.setGrade(60);
        result = instance.print();
        assertEquals(expResult, result);
        
        expResult = "C";
        instance.setGrade(70);
        result = instance.print();
        assertEquals(expResult, result);
        
        expResult = "B";
        instance.setGrade(80);
        result = instance.print();
        assertEquals(expResult, result);
        
        expResult = "A";
        instance.setGrade(90);
        result = instance.print();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrade method, of class Grades.
     */
    @Test
    public void testGetGrade() {
        System.out.println("getGrade");
        Grades instance = new Grades(50);
        
        int result = instance.getGrade();
        assertEquals(50, result);
    }

    /**
     * Test of setGrade method, of class Grades.
     */
    @Test
    public void testSetGrade() {
        System.out.println("setGrade");
        int _grade = 0;
        Grades instance = new Grades(50);
        instance.setGrade(60);
    }
    
}
