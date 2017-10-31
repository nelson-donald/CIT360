/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.javabean;

import java.io.Serializable;

/**
 *
 * @author neldo
 */
public class MyJavaBean implements Serializable {
    
//================================================================================
//Private variables
//================================================================================
    private String URI;
    
 
//================================================================================
//Constructors
//================================================================================
    public MyJavaBean(){
        
    }
    
    public MyJavaBean(String url)
    {
        this.URI = url;
    }

//================================================================================
//Public Properties
//================================================================================
    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }
    
    
}
