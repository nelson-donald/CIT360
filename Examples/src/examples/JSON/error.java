/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.JSON;

import examples.Logging.Logit;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author neldo
 * This is my class for testing JSON
 */
public class error implements Serializable {
    
    
//================================================================================
//Private variables
//================================================================================
    
    private String error;
    
    private String object_or_array;
    
    private String error_info;
    
    private Boolean validate;
    
    
//================================================================================
//Public Properties
//================================================================================
    
    public String getError_Info(){
        return this.error_info;
    }
    public Boolean getValidate(){
        return this.validate;
    }
    public String getError(){
        return this.error;
    }
    public String getObject_Or_Array(){
        return this.object_or_array;
    }
    
    
//================================================================================
//Constructors
//================================================================================
    
    public error(String message, String object_or_array, String error_info, Boolean validate) {
	this.error=message;
        this.object_or_array=object_or_array;
        this.error_info=error_info;
        this.validate=validate;
    }
	
    public error(HashMap aMapRepresentation){
	this.error = (String)aMapRepresentation.get("error");
        Logit.verbose((String)aMapRepresentation.get("error"));
        this.object_or_array = (String)aMapRepresentation.get("object_or_array");
        this.error_info = (String)aMapRepresentation.get("error_info");
        this.validate = (Boolean)aMapRepresentation.get("validate");
		
    }
}
