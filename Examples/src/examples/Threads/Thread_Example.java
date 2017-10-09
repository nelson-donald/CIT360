/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.Threads;

import examples.Logging.Logit;

/**
 *
 * @author neldo
 */
public class Thread_Example {
    
    public void start()
    {
        Runnable task = () -> {
            
        Logit.verbose("================================================================================");
        Logit.verbose("Thread");
        Logit.verbose("================================================================================");
            String threadName = Thread.currentThread().getName();
            Logit.verbose("Good day " + threadName);
        };
        
        //Run the task on the main thread
        task.run();
        
        //Create a new thread and tell it to process the Task we created
        Thread thread = new Thread(task);
        
        //Start the new thread
        thread.start();
        
        //show that we finished the main thread
        Logit.verbose("Done!");
    }
}
