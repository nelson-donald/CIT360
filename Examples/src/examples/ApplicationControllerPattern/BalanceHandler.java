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
public class BalanceHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap){
            System.out.println("Your current balance is: " + Account.getBalance());
    }
}