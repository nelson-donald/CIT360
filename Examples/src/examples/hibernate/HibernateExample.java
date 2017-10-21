/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.hibernate;

import examples.Logging.Logit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author neldo
 */
public class HibernateExample {
    
    
    
//================================================================================
//Private properties
//================================================================================
    private NewHibernateUtil helper;
    private Session session;
    


//================================================================================
//Public methods * The 4 CRUD methods (Create, Read, Update, Delete)
//================================================================================   
    
    /**
     * @return 
     */
    public Artist createArtist(){
        
        
        Artist artist = new Artist("","");
        
        
        try{
            Logit.verbose("Create a new Artist object");
            artist = new Artist("Donnie","Nelson");
            Logit.verbose("Open the new Hibernate Session");
            session = helper.getSessionFactory().openSession();
            Logit.verbose("Begin a new transaction");
            session.beginTransaction();
            Logit.verbose("Save the changes");
            session.save(artist);
            Logit.verbose("Comit the changes to the database");
            session.getTransaction().commit();
            Logit.verbose("Clost the transaction");
            session.close();
        }catch(Exception ex){
            Logit.error(ex.getMessage());
        }
        
        Logit.verbose("Return the Artist obect");
        return artist;
    }
    
    /**
     * 
     * @param a The Artist that needs to be deleted from the database
     */
    public void deleteArtist(Artist a)
    {
        
        Artist tmpArtist = null;

        try{
            session = helper.getSessionFactory().openSession();
            session.beginTransaction();
            tmpArtist = (Artist)session.load(Artist.class, a.getId());
            if(tmpArtist != null){
                session.delete(tmpArtist);
            }
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            Logit.error(ex.getMessage());
        }
            finally{
            session.close();    
        }
    }
    
    public void readArtists( ){
        try{
            session = helper.getSessionFactory().openSession();
            session.beginTransaction();
            List listArtists = session.createQuery("FROM examples.hibernate.Artist").list();
            for (Iterator iterator = listArtists.iterator(); iterator.hasNext();){
                Artist tmpArtist = (Artist) iterator.next();
                Logit.verbose(tmpArtist.getId() + " \t " + tmpArtist.getFirst_name() + " \t " + tmpArtist.getLast_name());
                
            }
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            Logit.error(ex.getMessage());
        }
            finally{
            session.close();    
        }
     }
    
    public void updateArtist(Artist a)
    {
        Artist tmpArtist = null;

        try{
            session = helper.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(a);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            Logit.error(ex.getMessage());
        }
            finally{
            session.close();    
        }
    }
    
}
