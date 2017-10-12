/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.JSON;

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
    
    private String _Error;
    
    private String _Object_or_array;
    
    private String _Error_info;
    
    private Boolean _Validate;
    
    
//================================================================================
//Public Properties
//================================================================================
    
    public String getError_Info(){
        return this._Error_info;
    }
    public Boolean getValidate(){
        return this._Validate;
    }
    public String getError(){
        return this._Error;
    }
    public String getObject_Or_Array(){
        return this._Object_or_array;
    }
    
    
//================================================================================
//Constructors
//================================================================================
    
    public error(String message, String object_or_array, String error_info, Boolean validate) {
	_Error=message;
        _Object_or_array=object_or_array;
        _Error_info=error_info;
        _Validate=validate;
    }
	
    public error(HashMap aMapRepresentation){
	this._Error = (String)aMapRepresentation.get("error");
        this._Object_or_array = (String)aMapRepresentation.get("object_or_array");
        this._Error_info = (String)aMapRepresentation.get("error_info");
        this._Validate = (Boolean)aMapRepresentation.get("validate");
		
    }
}
