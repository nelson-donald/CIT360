/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author neldo
 */
public class Thread_Example {
    
    public void CountToTen()
    {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Good day " + threadName);
        };
        
        task.run();
        
        Thread thread = new Thread(task);
        thread.start();
        
        System.out.println("Done!");
    }
}
