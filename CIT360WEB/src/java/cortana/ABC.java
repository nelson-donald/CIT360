/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortana;

import examples.Logging.Logit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.quickconnectfamily.json.JSONUtilities;

/**
 *
 * @author neldo
 */
public class ABC {
    
//================================================================================
//private variables
//================================================================================
    private List<Item> items;
    
//================================================================================
//Constructors
//================================================================================
    public ABC(HashMap json){
        items = new ArrayList<Item>();
        try{
            
            ArrayList al = (ArrayList)json.get("items");
            
            al.forEach((a)->{
                Item i = new Item((HashMap)a);
                this.items.add(i);
                    });
        }
        catch(Exception ex)
        {
            Logit.error(ex.getMessage());
        }
        finally{
            
        }
    }

    
//================================================================================
//getter/setter
//================================================================================
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    
}
