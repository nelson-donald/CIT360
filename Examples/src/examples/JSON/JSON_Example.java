/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.JSON;

import examples.Logging.Logit;
import java.awt.Event;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            Logit.verbose("---------- The JSON text from the Object using stringify ----------");
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
                        
            //Write to the file
                _out.write(textJSON);
            _out.close();
            
            }catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            
            
//================================================================================
//Step 3, read the JSON from a text file and convert back to an object using parse
//================================================================================

            //read from a file
            String _content = "";
            
            try{
                //Read the entire contents of the file
                _content = new String(Files.readAllBytes(Paths.get(_fileName)));
                
                //Call the Parse methos. This method returns a HashMap or Array.
                //I converted to HashMap and passed into my Error class
                error _newError = new error((HashMap)JSONUtilities.parse(_content));
                                
                //Log the New JSON object
                Logit.verbose("---------- The New JSON Object from File using parse to convert back to Object ----------");
                Logit.verbose("Error : " + _newError.getError());
                Logit.verbose("Error_Info : " + _newError.getError_Info());
                Logit.verbose("Validate: " + _newError.getValidate());
                Logit.verbose("Object_or_Array: " + _newError.getObject_Or_Array());
            
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
