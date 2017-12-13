/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.View;

import examples.Logging.Logit;

/**
 *
 * @author neldo
 */
public class StudentView {
   public void printStudentDetails(String studentName, String studentRollNo){
       
        Logit.verbose("================================================================================");
        Logit.verbose("MVC demo");
        Logit.verbose("================================================================================");
        Logit.verbose("Student: ");
        Logit.verbose("Name: " + studentName);
        Logit.verbose("Roll No: " + studentRollNo);
   }
}

