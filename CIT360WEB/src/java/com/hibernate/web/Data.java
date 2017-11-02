/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;

/**
 *
 * @author neldo
 */
@ManagedBean
@SessionScoped
public class Data {
    private Artist a;
    private HibernateUtil helper;
    private Session session;
    
    public void addArtist(){
        try{
        //System.out.println("1");
        a = new Artist("Donnie","Nelson");
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
