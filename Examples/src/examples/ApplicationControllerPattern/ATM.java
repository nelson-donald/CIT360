/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.ApplicationControllerPattern;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author neldo
 */
public class ATM {
    private ApplicationController theAppController = new ApplicationController();
    
    public void init(){
        theAppController.mapCommand("deposit",new DepositHandler());
        theAppController.mapCommand("withdrawal",new WithdrawalHandler());
        theAppController.mapCommand("balance",new BalanceHandler());
    }
    
    public void start(){
        Boolean bQuit = false;
        
        do{
          
            System.out.println("\r\nPlease select from one of the options:\r\n\r\nA = Deposit\r\nB = Withdrawal\r\nC = Balance\r\nD = Quit \r\n");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine().toUpperCase();
            if(option.charAt(0) == 'A'){
            
                System.out.println("Please enter the amount to deposit: ");
                int val = scanner.nextInt();
                HashMap<String,Object> data = new HashMap();
                data.put("deposit",val);
                theAppController.handleRequest("deposit", data);
            }
            else if(option.charAt(0) == 'B')
            {
                System.out.println("Please enter the amount to withdrawal: ");
                int val = scanner.nextInt();
                HashMap<String,Object> data = new HashMap();
                data.put("withdrawal",val);
                theAppController.handleRequest("withdrawal", data);
            }
            else if(option.charAt(0) == 'C'){
            

                theAppController.handleRequest("balance", null);

            }
            else if(option.charAt(0) == 'D'){
                bQuit = true;
            }  
        } while(bQuit == false);
    }
}
