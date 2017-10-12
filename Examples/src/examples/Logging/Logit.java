/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.Logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author neldo
 */
public class Logit {
 
    
//================================================================================
//Private variables
//================================================================================
    
    //This is the full path to the file for the logging
    private String _FileName = null;
    
    //This is the static object of itself used as a singleton reference
    private static Logit _Logit = null;
    
//================================================================================
//Constructor
//================================================================================
    
    //This is the constructor. It does a bunch of prep work for the logging
    //to be smooth
    public Logit()
    {
        //If the filename has not been determined
        if(_FileName == null){
            Date _d = new Date();
            _FileName = "C:\\Logs\\Donald.Nelson.";
            DateFormat _dateFormat = new SimpleDateFormat("yyyy");
            _FileName += _dateFormat.format(_d);
            _dateFormat = new SimpleDateFormat("MM");
            _FileName += _dateFormat.format(_d);
            _dateFormat = new SimpleDateFormat("dd");
            _FileName += _dateFormat.format(_d);
            _FileName += ".";
            _dateFormat = new SimpleDateFormat("HH");
            _FileName += _dateFormat.format(_d);
            _dateFormat = new SimpleDateFormat("mm");
            _FileName += _dateFormat.format(_d);
            _dateFormat = new SimpleDateFormat("ss");
            _FileName += _dateFormat.format(_d) + ".html";
                
            try
            {
            // Use relative path for Unix systems
            File f = new File(_FileName);

            f.getParentFile().mkdirs(); 
            f.createNewFile();
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());                
            }
            
            //Create the HTML file with appropriate HTML
            write("<html>");
            write("<head>");
            write("     <style>");
            write("         .red{color: red;}");
            write("     </style>");
            write("</head>");
            write("<body>");
        }
    }
    
    
//================================================================================
//Public static methods
//================================================================================
    
    //The static method for logging verbose messages
    public static void verbose(String s){
        
        //Call the startup code every time to make sure that there is in
        //fact an object and a file to write to
        startup();
        
        //call the singleton object's write method which will write the
        //logged message to the file
        _Logit.write(_Logit.format(s));
    }
    
    //The static method for logging error messages
    public static void error(String s){
        
        //Call the startup code every time to make sure that there is in
        //fact an object and a file to write to
        startup();
        
        //call the singleton object's write method which will write the
        //logged message to the file
        _Logit.write(_Logit.format(s,"red"));
    }
    
    
    
//================================================================================
//Private static methods
//================================================================================
    
    //Make this call to instantiate the Java Class with a new isntance of itself
    private static void startup()
    {
        //Creates a private variable within the class that is itself a singleton
        //object
        if(_Logit == null){
            _Logit = new Logit();
        }
        
    }
    
    
//================================================================================
//Private methods
//================================================================================
    
    //Converts the line of log file into an HTML format
    private String format(String s, String c){
        String _result = "";
        try
        {
            DateFormat _dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date _d = new Date();
            _result += "[ " + _dateFormat.format(_d) + " ]";
            _result += " - ";
            _result += s;
            
            //Write to the console
            System.out.println(_result);
            
            _result ="<div class=\"" + c + "\">" + _result + "</div>";
        }catch(Exception ex)
        {
            
            System.out.println(ex.getMessage());
        }
        return _result;
    }
    
    //takes the string and forwards to the format class that does all the work
    private String format(String s){
        
        return format(s,"");
    }
    
    //Writes the log to the file
    private synchronized void write(String s){
        
        //Remove the last line of the file
        try{
            RandomAccessFile raf = new RandomAccessFile(_FileName, "rw");
            raf.setLength(raf.length() - 14);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            
        }
                
        //This try block is the equivelent of a C# using statment
        try(FileWriter _fileWriter = new FileWriter(_FileName, true)){
            BufferedWriter _out = new BufferedWriter(_fileWriter);
                        
            //Write to the log file
            _out.write(s + "\r\n");
            
            //Close the log file wiht the ending to an HTML page
            _out.write("</body></html>");
            _out.close();
        
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
