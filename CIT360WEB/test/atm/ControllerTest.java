/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import atm.controller.Controller;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neldo
 */
public class ControllerTest {
    
    public ControllerTest() {
        
        
    }

    /**
     * Test of getBalance method, of class Controller.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        String jsonacc = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":0}";
        Controller instance = new Controller();
        String expResult = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":100}";
        String result = instance.getBalance(jsonacc);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalanceFromAccount method, of class Controller.
     */
    @Test
    public void testGetBalanceFromAccount() {
        System.out.println("getBalanceFromAccount");
        String jsonacc = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":0}";
        Controller instance = new Controller();
        int expResult = 125;
        int result = instance.getBalanceFromAccount(jsonacc);
        assertEquals(expResult, result);
    }

    /**
     * Test of withdrawalFunds method, of class Controller.
     */
    @Test
    public void testWithdrawalFunds() {
        System.out.println("withdrawalFunds");
        String _content = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":125}";
        Controller instance = new Controller();
        String expResult = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":125}";
        String result = instance.withdrawalFunds(_content);
        assertEquals(expResult, result);
    }

    /**
     * Test of depositFunds method, of class Controller.
     */
    @Test
    public void testDepositFunds() {
        System.out.println("depositFunds");
        String _content = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":225}";
        Controller instance = new Controller();
        String expResult = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":225}";
        String result = instance.depositFunds(_content);
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class Controller.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String accountNum = "11111";
        String pinCode = "11111";
        Controller instance = new Controller();
        String expResult = "{\"ID\":2,\"accountNumber\":\"11111\",\"pinCode\":\"11111\",\"balance\":125}";
        String result = instance.login(accountNum, pinCode);
        assertEquals(expResult, result);
    }
    
}
