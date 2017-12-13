/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import atm.model.Account;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author neldo
 */
public class AccountTest {
    
    public AccountTest() {
        //Create the new Instance
        Account instance = new Account();
        
        //Set the Account Number value
        instance.setAccountNumber("12345");
        
        //Validate that the setID did in fact set the ID correctly.
        assertEquals("12345",instance.getAccountNumber());
        
        //validating that it is not 0
        assertNotEquals("1111", instance.getAccountNumber());
        
        //Set the pin code
        instance.setPinCode("12345");
        
        //Validate that the setID did in fact set the ID correctly.
        assertEquals("12345",instance.getPinCode());
        
        //validating that it is not 0
        assertNotEquals("", instance.getPinCode());
        
        //Set the unique id
        instance.setID(10);
        
        //Validate that the setID did in fact set the ID correctly.
        assertEquals(10,instance.getID());
        
        //validating that it is not 0
        assertNotEquals(0, instance.getID());
        
        //Set the balance
        instance.setBalance(100);
        
        //Validate that the setID did in fact set the ID correctly.
        assertEquals(100,instance.getBalance());
        
        //validating that it is not 0
        assertNotEquals(0, instance.getBalance());
        
        
    }

    /**
     * Test of getAccountNumber method, of class Account.
     */
    @Test
    public void testGetAccountNumber() {
        System.out.println("getAccountNumber");
        Account instance = new Account();
        String expResult = "1111";
        String result = instance.getAccountNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccountNumber method, of class Account.
     */
    @Test
    public void testSetAccountNumber() {
        System.out.println("setAccountNumber");
        String accountNumber = "12345";
        Account instance = new Account();
        instance.setAccountNumber(accountNumber);
        String expResult = "12345";
        String result = instance.getAccountNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPinCode method, of class Account.
     */
    @Test
    public void testGetPinCode() {
        System.out.println("getPinCode");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getPinCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPinCode method, of class Account.
     */
    @Test
    public void testSetPinCode() {
        System.out.println("setPinCode");
        String pinCode = "12345";
        Account instance = new Account();
        instance.setPinCode(pinCode);
        String result = instance.getPinCode();
        assertEquals(pinCode, result);
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBalance method, of class Account.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        int balance = 100;
        Account instance = new Account();
        instance.setBalance(balance);
        int result = instance.getBalance();
        assertEquals(balance, result);
    }

    /**
     * Test of getID method, of class Account.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class Account.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 10;
        Account instance = new Account();
        instance.setID(ID);
        
        //Validate that the setID did in fact set the ID correctly.
        assertEquals(10,instance.getID());
        
        //validating that it is not 0
        assertNotEquals(0, instance.getID());
    }
    
}
