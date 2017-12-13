/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.controller;

import atm.model.Account;
import examples.Logging.Logit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.quickconnectfamily.json.JSONUtilities;

/**
 *
 * @author neldo
 */
public class Controller {
    
//================================================================================
//Private properties
//================================================================================
    private NewHibernateUtil1 helper;
    private Session session;
    
    
//================================================================================
//Constructors
//================================================================================
    public Controller()
    {
        
    }
    
//================================================================================
//public methods
//================================================================================
    public String getBalance(String jsonacc){
        String result = "";
        Account tmpAccount = new Account();
                
                //Read the balance from the database using hibernate
                try{
                    
                    //Convert the JSON string to an object
                    Account account = new Account((HashMap)JSONUtilities.parse(jsonacc));
                    
                    //Account account = new Account((HashMap)JSONUtilities.parse(_content));
                    
                    session = helper.getSessionFactory().openSession();
                    session.beginTransaction();
                    List listArtists = session.createQuery("FROM atm.model.Account").list();
                    for (Iterator iterator = listArtists.iterator(); iterator.hasNext();){
                        tmpAccount = (Account) iterator.next();
                        if(tmpAccount.getID() == account.getID()){
                            result = JSONUtilities.stringify(tmpAccount);
                        }
                    
                
                    }
                    session.getTransaction().commit();
                }catch(Exception ex){
                    session.getTransaction().rollback();
                }
                    finally{
                    session.close();    
                }
                
        return result;
    }
    
    public int getBalanceFromAccount(String jsonacc){
        int result = 0;
        Account tmpAccount = new Account();
                
                //Read the balance from the database using hibernate
                try{
                    
                    Account account = new Account((HashMap)JSONUtilities.parse(jsonacc));
                    
                    //Convert the JSON string to an object
                    //Account account = new Account((HashMap)JSONUtilities.parse(_content));
                    
                    session = helper.getSessionFactory().openSession();
                    session.beginTransaction();
                    List listArtists = session.createQuery("FROM atm.model.Account").list();
                    for (Iterator iterator = listArtists.iterator(); iterator.hasNext();){
                        tmpAccount = (Account) iterator.next();
                        if(tmpAccount.getID() == account.getID()){
                            result = tmpAccount.getBalance();
                        }
                    
                
                    }
                    session.getTransaction().commit();
                }catch(Exception ex){
                    session.getTransaction().rollback();
                }
                    finally{
                    session.close();    
                }
                
        return result;
    }
    
    public String withdrawalFunds(String _content){
        Account a = new Account();
        String result = "";
        
        try{
                    
            //Convert the JSON string to an object
            a = new Account((HashMap)JSONUtilities.parse(_content));
                        
            //Save the balance back into the Database
            session = helper.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(a);
            session.getTransaction().commit();
            result = JSONUtilities.stringify(a);
        }catch(Exception ex){
            session.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }
            finally{
            session.close();    
        }
        
        return result;
    }
    
    public String depositFunds(String _content){
        
        Account a = new Account();
        String result = "";
        
        try{
                    
            //Convert the JSON string to an object
            a = new Account((HashMap)JSONUtilities.parse(_content));
            
            
            //Save the balance back into the Database
            session = helper.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(a);
            session.getTransaction().commit();
            result = JSONUtilities.stringify(a);
        }catch(Exception ex){
            session.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }
            finally{
            session.close();    
        }
        
        return result;
    }
    
    public String login(String accountNum, String pinCode){
        String result = "error";
        Account tmpAccount = new Account();
        //tmpAccount.setAccountNumber(accountNum);
        //tmpAccount.setPinCode(pinCode);
        
                
                //Read the balance from the database using hibernate
                try{
                    
                    //Convert the JSON string to an object
                    //Account account = new Account((HashMap)JSONUtilities.parse(_content));
                    
                        //result += "1";
                    session = helper.getSessionFactory().openSession();
                        //result += "1";
                    session.beginTransaction();
                        //result += "1";
                    List listArtists = session.createQuery("FROM atm.model.Account").list();
                        //result += "1";
                    for (Iterator iterator = listArtists.iterator(); iterator.hasNext();){
                        tmpAccount = (Account) iterator.next();
                        //result += "D:" + tmpAccount.getAccountNumber();
                        if(tmpAccount.getAccountNumber().equals(accountNum))
                        {
                            //result += "p"+tmpAccount.getPinCode();
                            if(tmpAccount.getPinCode().equals(pinCode)){
                                //result += "N";
                                result = JSONUtilities.stringify(tmpAccount);
                            }
                        }
                    
                
                    }
                    session.getTransaction().commit();
                }catch(Exception ex){
                    session.getTransaction().rollback();
                }
                    finally{
                    session.close();    
                }
                
        return result;
        
    }
}
