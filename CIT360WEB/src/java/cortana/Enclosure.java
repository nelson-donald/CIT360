/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortana;

/**
 *
 * @author neldo
 */
public class Enclosure {
    private String thumbnail;
    
    public Enclosure(String thum){
        this.thumbnail=thum;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    
}
