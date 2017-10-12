/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.JSON;

import examples.Logging.Logit;
import java.awt.Event;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONParser;
import org.quickconnectfamily.json.JSONUtilities;

 

/**
 *
 * @author neldo
 */
public class JSON_Example {
    
    public  JSON_Example(){
        
        QcJSON();
    }
    
    
    public void QcJSON(){
        
        Logit.verbose("================================================================================");
        Logit.verbose("JSON Example");
        Logit.verbose("================================================================================");
        try
        {
            
//================================================================================
//Step 1 ... Get the JSON from a remote URL
//================================================================================
            
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
                
             
//================================================================================
//Step 2, Write the JSON to a text file
//================================================================================
            
            //Convert the serializable object back to a string
            String textJSON = JSONUtilities.stringify(readObject);
            
            //Log it just to prove it looks like JSON text
            Logit.verbose(textJSON);
            
            String _fileName = "C:\\Logs\\JSON.txt";
            
            //Create the file
            File f = new File(_fileName);
            
            //Make the directory in case it does not exist
            f.getParentFile().mkdirs(); 
            
            //delete the file
            f.delete();
            
            //Create a new one
            f.createNewFile();
            
            //Write to a file
            try(FileWriter _fileWriter = new FileWriter(_fileName, true)){
            BufferedWriter _out = new BufferedWriter(_fileWriter);
                        
            //Write to the log file
            _out.write(textJSON);
            _out.close();
        
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
            
            
        }
        catch(Exception ex)
        {
        
                Logit.error(ex.getMessage());
        }
            
    }
}
