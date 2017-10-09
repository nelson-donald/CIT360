/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examples.Collections;

import examples.Logging.Logit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author neldo
 */
public class MyCollections {
    
    //Show how to use a List of strings
    public void doList()
    {
         //Instantiate a new ArrayList of type String
        List<String> list = new ArrayList<String>();
        Logit.verbose("================================================================================");
        Logit.verbose("List");
        Logit.verbose("================================================================================");
        
        //Add in the days of the week, excluding Tuesday
        list.add("Sunday");
        list.add("Monday");
        list.add("Tuesday");
        
        System.out.println(list);
        
        Collections.addAll(list,"Wednesday","Thursday");
        
        Logit.verbose("After adding elements:  " + list);
        
        String[] strArray = {"Friday","Saturday"};
        Collections.addAll(list, strArray);
        
        Logit.verbose("After adding array:     " + list);
        
    }
    
    //Show how to use a HashTable
    public void doHashTable()
    {
         //Instantiate a new ArrayList of type String
        Hashtable<Integer,String> hashTable = new Hashtable<Integer,String>();
        Logit.verbose("================================================================================");
        Logit.verbose("HashTable");
        Logit.verbose("================================================================================");
        
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
        Logit.verbose("What is the second day of the week? " + hashTable.get(2));
        Logit.verbose("Is Empty? "+hashTable.isEmpty());
        
        //Remove Hump Day (Wednesday)
        hashTable.remove(4);
        
        //Now the output shows Tuesday in the correct position
        
        //See all items
        System.out.println(hashTable);
        
        Logit.verbose("Size: "+hashTable.size());
    }
    
    //Show how to use an ArrayList
    public void doArrayList()
    {
        //Instantiate a new ArrayList of type String
        ArrayList<String> arrayList = new ArrayList<String>();
        Logit.verbose("================================================================================");
        Logit.verbose("ArrayList");
        Logit.verbose("================================================================================");
        
        //Add in the days of the week, excluding Tuesday
        arrayList.add("Monday");
        arrayList.add("Wednesday");
        arrayList.add("Thursday");
        arrayList.add("Friday");
        arrayList.add("Saturday");
        arrayList.add("Sunday");
        
        //See that Tuesday is missing
        System.out.println(arrayList);
        Logit.verbose("Contains 'Tuesday'? " + arrayList.contains("Tuesday"));
        
        //Add Tuesday in ad position 1
        //This will force the items currently in the array, down 1 position
        //to accomodate the new item.
        arrayList.add(1,"Tuesday");
        
        //Now the output shows Tuesday in the correct position
        System.out.println(arrayList);
        
        //this now shows that Wednesday is in position 2
        Logit.verbose("Is Empty? "+arrayList.isEmpty());
        Logit.verbose("Index of 'Wednesday' is "+arrayList.indexOf("Wednesday"));
        Logit.verbose("Size: "+arrayList.size());
        
        
    }
    
    //Show how to use the LinkedList
    public void doLinkedList()
    {
        LinkedList<String> linkedList = new LinkedList<String>();

        Logit.verbose("================================================================================");
        Logit.verbose("LinkedLists");
        Logit.verbose("================================================================================");
        
        linkedList.add("Monday");
        linkedList.add("Tuesday");
        linkedList.add("Wednesday");
        linkedList.add("Thursday");
        linkedList.add("Friday");
        linkedList.add("Saturday");
        linkedList.add("Sunday");
        
        System.out.println(linkedList);
        Logit.verbose("Size: " + linkedList.size());
        Logit.verbose("Is Empty?: " + linkedList.isEmpty());
        Logit.verbose("Contains 'Sunday'?: " + linkedList.contains("Sunday"));
        
    }
    
}
