/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.HTTPUrlConnection;

import examples.Logging.Logit;
import examples.javabean.MyJavaBean;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author neldo
 */
public class HttpConnectionTest {
    
//================================================================================
//Private variables
//================================================================================
    private MyJavaBean _javaBean;
    
//================================================================================
//Constructors
//================================================================================
    public HttpConnectionTest()
    {
        _javaBean=new MyJavaBean();
        _javaBean.setURI("http://validate.jsontest.com/?json=%7B%22key%22:%22value%22");
    }
 
//================================================================================
//Public Methods
//================================================================================
    public String getContent(){
        Logit.verbose("================================================================================");
        Logit.verbose("HttpUrlConnection Example");
        Logit.verbose("================================================================================");
            StringBuilder content = new StringBuilder();
        try{
            URL url = new URL(this._javaBean.getURI());
            
            Logit.verbose("Open HttpUrlConnection");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            
            try{
                Logit.verbose("Get Input Stream");
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                
                
                Logit.verbose("Convert to String");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                
                String line;
                
                while((line = bufferedReader.readLine()) != null){
                    content.append(line).append("\n");
                }
                
            }
            catch(Exception ex)
            {
                Logit.error(ex.getMessage());
            }
            finally{
                
                Logit.verbose("Close HttpUrlConnection");
                urlConnection.disconnect();
            }
            
        }
        catch(Exception ex){
            
        }
        
        Logit.verbose("Return content");
        return content.toString();
    }
}
