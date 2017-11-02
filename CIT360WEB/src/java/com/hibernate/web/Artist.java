/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.web;

import java.sql.Date;

/**
 *
 * @author neldo
 */
public class Artist {
    
    private int id;
    
    private String first_name;
    
    private String last_name;
    
    //private Date date_created;
    
    public Artist(String f_name, String l_name){
        this.first_name = f_name;
        this.last_name = l_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    
    
}
