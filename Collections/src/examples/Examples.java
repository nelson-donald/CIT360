/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import examples.Controller.StudentController;
import examples.Model.Student;
import examples.View.StudentView;
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
        //======================================================================
        //Collections Examples
        //======================================================================
        //doLinkedList();
        //doArrayList();
        //doHashTable();
        //doList();
        
        //======================================================================
        //Thread Example
        //======================================================================
        //Thread_Example t_e=  new Thread_Example();
        //t_e.letsDoThis();
        
        //======================================================================
        //MVC Demo
        //======================================================================
        doMVCDemo();
        
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

   private static Student retrieveStudentFromDatabase(){
      Student student = new Student();
      student.setName("Robert");
      student.setRollNo("10");
      return student;
   }
    
    private static void doList()
    {
         //Instantiate a new ArrayList of type String
        List<String> list = new ArrayList<String>();
        System.out.println("================================================================================");
        System.out.println("List");
        System.out.println("================================================================================");
        
        //Add in the days of the week, excluding Tuesday
        list.add("Sunday");
        list.add("Monday");
        list.add("Tuesday");
        
        System.out.println(list);
        
        Collections.addAll(list,"Wednesday","Thursday");
        
        System.out.println("After adding elements:  " + list);
        
        String[] strArray = {"Friday","Saturday"};
        Collections.addAll(list, strArray);
        
        System.out.println("After adding array:     " + list);
        
    }
    
    private static void doHashTable()
    {
         //Instantiate a new ArrayList of type String
        Hashtable<Integer,String> hashTable = new Hashtable<Integer,String>();
        System.out.println("================================================================================");
        System.out.println("HashTable");
        System.out.println("================================================================================");
        
        //Add in the days of the week, excluding Tuesday
        hashTable.put(1,"Sunday");
        hashTable.put(2,"Monday");
        hashTable.put(3,"Tuesday");
        hashTable.put(4,"Wednesday");
        hashTable.put(5,"Thursday");
        hashTable.put(6,"Friday");
        hashTable.put(7,"Saturday");
        
        
        //See all items
        System.out.println(hashTable);
        System.out.println("What is the second day of the week? " + hashTable.get(2));
        System.out.println("Is Empty? "+hashTable.isEmpty());
        
        //Remove Hump Day (Wednesday)
        hashTable.remove(4);
        
        //Now the output shows Tuesday in the correct position
        
        //See all items
        System.out.println(hashTable);
        
        System.out.println("Size: "+hashTable.size());
    }
    
    private static void doArrayList()
    {
        //Instantiate a new ArrayList of type String
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("================================================================================");
        System.out.println("ArrayList");
        System.out.println("================================================================================");
        
        //Add in the days of the week, excluding Tuesday
        arrayList.add("Monday");
        arrayList.add("Wednesday");
        arrayList.add("Thursday");
        arrayList.add("Friday");
        arrayList.add("Saturday");
        arrayList.add("Sunday");
        
        //See that Tuesday is missing
        System.out.println(arrayList);
        System.out.println("Contains 'Tuesday'? " + arrayList.contains("Tuesday"));
        
        //Add Tuesday in ad position 1
        //This will force the items currently in the array, down 1 position
        //to accomodate the new item.
        arrayList.add(1,"Tuesday");
        
        //Now the output shows Tuesday in the correct position
        System.out.println(arrayList);
        
        //this now shows that Wednesday is in position 2
        System.out.println("Is Empty? "+arrayList.isEmpty());
        System.out.println("Index of 'Wednesday' is "+arrayList.indexOf("Wednesday"));
        System.out.println("Size: "+arrayList.size());
        
        
    }
    
    private static void doLinkedList()
    {
        LinkedList<String> linkedList = new LinkedList<String>();

        System.out.println("================================================================================");
        System.out.println("LinkedLists");
        System.out.println("================================================================================");
        
        linkedList.add("Monday");
        linkedList.add("Tuesday");
        linkedList.add("Wednesday");
        linkedList.add("Thursday");
        linkedList.add("Friday");
        linkedList.add("Saturday");
        linkedList.add("Sunday");
        
        System.out.println(linkedList);
        System.out.println("Size: " + linkedList.size());
        System.out.println("Is Empty?: " + linkedList.isEmpty());
        System.out.println("Contains 'Sunday'?: " + linkedList.contains("Sunday"));
        
    }
    
}
