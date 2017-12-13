/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author neldo
 * This is the model
 */
public class Account  implements Serializable {
    
//================================================================================
//private variables
//================================================================================
    private int ID = 0;
    
    private String accountNumber = "1111";
    
    private String pinCode = "";
    
    private int balance = 0;
    
    
//================================================================================
//Constructors
//================================================================================
    
    public Account(){
        
    }
    
    public Account(String accountNumber, String pinCode, int balance)
    {
        this.accountNumber=accountNumber;
        this.pinCode=pinCode;
        this.balance=balance;
    }
    public Account (HashMap hash)
    {
        try
        {
        this.accountNumber = (String)hash.get("accountNumber");
        this.pinCode = (String)hash.get("pinCode");
        balance = (int)((long)hash.get("balance"));
        ID = (int)((long) hash.get("ID"));
    }
        catch(Exception ex){
            System.out.println(ex.getMessage());}
    }
    
    //sharedpreferences
    //onPostExecute

//================================================================================
//getter/setter
//================================================================================
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
}
