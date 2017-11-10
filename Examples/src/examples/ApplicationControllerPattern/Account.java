/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.ApplicationControllerPattern;

/**
 *
 * @author neldo
 */
public class Account {
    
    private static int balance = 100;
    
    
    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        Account.balance = balance;
    }
    
    
}
