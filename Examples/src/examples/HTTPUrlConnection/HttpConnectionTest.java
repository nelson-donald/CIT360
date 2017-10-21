/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.HTTPUrlConnection;

import examples.javabean.MyJavaBean;
import java.net.URL;

/**
 *
 * @author neldo
 */
public class HttpConnectionTest {
 
    public void Start(MyJavaBean theURL){
        try{
            URL url = new URL(theURL.getURI());
            
        }
        catch(Exception ex){
            
        }
    }
}
