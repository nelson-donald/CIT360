/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortana;

import examples.Logging.Logit;
import java.util.HashMap;
import org.quickconnectfamily.json.JSONUtilities;

/**
 *
 * @author neldo
 */
public class Item {
    
//================================================================================
//private variables
//================================================================================
    private String title = "";
    private String pubDate = "";
    private String link = "";
    private String guid = "";
    private String author = "";
    private String thumbnail = "";
    private String description = "";
    private String content = "";
    private String enclosure = "";
    private String[] categories;
    
    
//================================================================================
//Constructors
//================================================================================
    public Item(HashMap json){
        setup(json);
    }

    public Item(String s){
        try{
            //Logit.verbose("123");
            //Logit.verbose(s);
            HashMap hm = (HashMap)JSONUtilities.parse(s);
            //Logit.verbose("123");
            setup(hm);
        }
        catch(Exception ex){
         Logit.error("!!!!!" + ex.getMessage());
        }
    }
    
    
//================================================================================
//private methods
//================================================================================
    private void setup(HashMap json){
        try{
            
        Logit.verbose("A");
        this.title = (String)json.get("title");
        Logit.verbose(this.title);
        }
        catch(Exception ex)
        {Logit.error(ex.getMessage());}
        try{
            this.pubDate = (String)json.get("pubDate");
        }
        catch(Exception ex)
        {}
        try{
            this.link = (String)json.get("link");
        }
        catch(Exception ex)
        {}
        try{
            this.guid = (String)json.get("guid");
        }
        catch(Exception ex)
        {}
        try{
            this.author = (String)json.get("author");
        }
        catch(Exception ex)
        {}
        try{
            this.thumbnail = (String)json.get("thumbnail");
        }
        catch(Exception ex)
        {}
        try{
            this.description = (String)json.get("description");
        }
        catch(Exception ex)
        {}
        try{
            this.content = (String)json.get("content");
        }
        catch(Exception ex)
        {}
        try{
            this.enclosure = (String)json.get("enclosure");
        }
        catch(Exception ex)
        {}
    }
    
//================================================================================
//getter/setter
//================================================================================
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
    
    
}
