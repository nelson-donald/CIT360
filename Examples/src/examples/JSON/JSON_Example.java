/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.JSON;

import examples.Logging.Logit;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONParser;

/**
 *
 * @author neldo
 */
public class JSON_Example {
    
    public  JSON_Example(){
        
        Logit.verbose("================================================================================");
        Logit.verbose("JSON Example");
        Logit.verbose("================================================================================");
        try
        {
            //Call the URL
            URL url = new URL("http://validate.jsontest.com/?json=%7B%22key%22:%22value%22");
            
            //Open the URL stream
            InputStream is = url.openStream();
            
            //create JSON stream from InputStream
            JSONInputStream jis = new JSONInputStream(is);  
            
            //Cast the JSONInputStream to a HashMap
            HashMap parsedJSONMap = (HashMap) jis.readObject();
            
            //Instantiate a new Error Oject using the HashMap
            error readObject = new error(parsedJSONMap);
                        
                    
                Logit.verbose("Error : " + readObject.getError());
                Logit.verbose("Error_Info : " + readObject.getError_Info());
                Logit.verbose("Validate: " + readObject.getValidate());
                Logit.verbose("Object_or_Array: " + readObject.getObject_Or_Array());
            
        }
        catch(Exception ex)
        {
        
                Logit.error(ex.getMessage());
        }
            
    }
}
