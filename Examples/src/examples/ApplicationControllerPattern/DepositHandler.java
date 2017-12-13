/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.ApplicationControllerPattern;

import java.util.HashMap;

/**
 *
 * @author neldo
 */
public class DepositHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap){
        int val = (int)dataMap.get("deposit");
        Account.setBalance(Account.getBalance() + val);
        System.out.println("You have deposited your funds. your new balance is $" + Account.getBalance());
        
    }
}