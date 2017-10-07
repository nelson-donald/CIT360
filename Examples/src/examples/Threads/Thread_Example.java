/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.Threads;

/**
 *
 * @author neldo
 */
public class Thread_Example {
    
    public void start()
    {
        Runnable task = () -> {
            
        System.out.println("================================================================================");
        System.out.println("Thread");
        System.out.println("================================================================================");
            String threadName = Thread.currentThread().getName();
            System.out.println("Good day " + threadName);
        };
        
        //Run the task on the main thread
        task.run();
        
        //Create a new thread and tell it to process the Task we created
        Thread thread = new Thread(task);
        
        //Start the new thread
        thread.start();
        
        //show that we finished the main thread
        System.out.println("Done!");
    }
}
