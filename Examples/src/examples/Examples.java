/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import examples.Threads.Thread_Example;
import Examples.Collections.MyCollections;
import examples.Controller.StudentController;
import examples.HTTPUrlConnection.HttpConnectionTest;
import examples.JSON.JSON_Example;
import examples.Logging.Logit;
import examples.Model.Student;
import examples.Threads.Executor_Example;
import examples.View.StudentView;
import examples.hibernate.Artist;
import examples.hibernate.HibernateExample;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author neldo
 */
public class Examples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Logit.error("Not a real Error. Just an example.");
        
        //======================================================================
        //Collections Examples
        //======================================================================
        
        //Instantiate a new MyCollections object
        MyCollections myCollections = new MyCollections();
        
        //Call the LikedList method
        myCollections.doLinkedList();
        
        //Call the ArrayList method
        myCollections.doArrayList();
        
        //Call the HashTable method
        myCollections.doHashTable();
        
        //Call the List method
        myCollections.doList();
        
        //======================================================================
        //Thread Example
        //======================================================================
        
        //Instantiate a new Thread Example object
        Thread_Example thread_Example=  new Thread_Example();
        
        //start the example
        thread_Example.start();
        
        try{
            //I'm forcing a sleep so that my log file looks clean after the last Thread exaple
            Thread.sleep(1000);
        }
        catch(Exception ex)
        {
            Logit.error(ex.getMessage());
        }
        
        //Executor Example
        Executor_Example executor_Example = new Executor_Example();
        executor_Example.Begin();
        
        //======================================================================
        //MVC Demo
        //======================================================================
        doMVCDemo();
        
        //======================================================================
        //JSON Example
        //======================================================================
        JSON_Example jse = new JSON_Example();
        
        
        //======================================================================
        //Hibernate Demo
        //======================================================================
        HibernateExample hc = new HibernateExample();
        
        Logit.verbose("================================================================================");
        Logit.verbose("Current Database table");
        Logit.verbose("================================================================================");
        //Show all rows in the database
        hc.readArtists( );
        
        
        Logit.verbose("================================================================================");
        Logit.verbose("New Entry in Database table");
        Logit.verbose("================================================================================");
        //Add to the database
        Artist a = hc.createArtist();        
        //Show all rows in the database
        hc.readArtists( );
        
        
        Logit.verbose("================================================================================");
        Logit.verbose("Update single row in Database table");
        Logit.verbose("================================================================================");
        a.setFirst_name("Amanda");
        hc.updateArtist(a);
        //Show all rows in the database
        hc.readArtists( );
        
        
        Logit.verbose("================================================================================");
        Logit.verbose("Delete single row in Database table");
        Logit.verbose("================================================================================");      
        a.setId(a.getId()-1);
        //Remove from the database
        hc.deleteArtist(a);        
        //Show all rows in the database
        hc.readArtists( );
        
        
        Logit.verbose("================================================================================");
        Logit.verbose("Current Database table");
        Logit.verbose("================================================================================");   
        //Show all rows in the database
        hc.readArtists( );
        
        //======================================================================
        //HttpUrlConnection
        //======================================================================
        
        HttpConnectionTest hct = new HttpConnectionTest();
        Logit.verbose(hct.getContent());
        
    }
    
    public static void doMVCDemo()
    {
      //fetch student record based on his roll no from the database
      Student model  = retrieveStudentFromDatabase();

      //Create a view : to write student details on console
      StudentView view = new StudentView();

      //Instantiate the controller and give it the Model and the View we just created
      StudentController controller = new StudentController(model, view);

      //Update the view
      controller.updateView();

      //update model data
      controller.setStudentName("John");

      //Update the view again
      controller.updateView();
   }

    //Pretends to get data from the database and return the Model object with the data
   private static Student retrieveStudentFromDatabase(){
      Student student = new Student();
      student.setName("Robert");
      student.setRollNo("10");
      return student;
   }
    
}
