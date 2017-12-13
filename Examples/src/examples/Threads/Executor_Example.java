/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.Threads;

import examples.Logging.Logit;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author neldo
 */
public class Executor_Example {
    
    public void Begin()
    {
        Logit.verbose("================================================================================");
        Logit.verbose("Executor Example");
        Logit.verbose("================================================================================");
        
        executorExecuteRunnable();
        executorSubmitRunnable();
        executorSubmitCallable();
        
    }
    
    private void executorExecuteRunnable()
    {
        //Create a new single thread excutor
        ExecutorService es = Executors.newSingleThreadExecutor();
            
        try
        {        
            //Call the execute mehod
            es.execute(new Runnable() {
                @Override
                public void run() {
                    //Get the thread name
                    String threadName = Thread.currentThread().getName();
            
                    //Log the thread name
                    Logit.verbose("ExecutorService - Execute method - " + threadName);
                }
            });
        }
        catch(Exception ex){
            Logit.error(ex.getMessage());
        }
        
            //Shutdown the Executor Service
            es.shutdown();
    }
    
    private void executorSubmitRunnable()
    {
        //Create a new single thread excutor
        ExecutorService es = Executors.newSingleThreadExecutor();
        
        try
        {
            
            //Call the execute mehod
            Future future = es.submit(new Runnable() {
                @Override
                public void run() {
                    //Get the thread name
                    String threadName = Thread.currentThread().getName();
                
                    //Log the thread name
                    Logit.verbose("ExecutorService - Submit method - " + threadName);
                }
            });
        
            future.get();
        }
        catch(Exception ex){
            Logit.error(ex.getMessage());
        }
        
        //Shutdown the Executor Service
        es.shutdown();
        
    }
    
    
    private void executorSubmitCallable()
    {
        //Create a new single thread excutor
        ExecutorService es = Executors.newSingleThreadExecutor();
        
        try
        {
            
            //Call the execute mehod
            Future future = es.submit(new Callable() {
                public Object call() throws Exception {
                    
                    Logit.verbose("ExecutorService - Submit method - Callable");
                    
                    //Send this string back as the result
                    return "We made it into the Callable and all I got was this lousy return value.";
                }
            });
        
            
            //Call the future.get but log the returned result
            Logit.verbose("Result: [ " + future.get() + " ]");
        }
        catch(Exception ex){
            Logit.error(ex.getMessage());
        }
        
        //Shutdown the Executor Service
        es.shutdown();
        
    }
}
