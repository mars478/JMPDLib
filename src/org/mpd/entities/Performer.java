package org.mpd.entities;

import java.util.HashMap;

/**
 *
 * @author mars
 */

public class Performer {
    
    private String performer;
    private HashMap<String,Album> albums;

    public Performer() {}
    
    public Performer(String performer){
        this.performer = performer;
    }
    
    public String getPerfomer() {
        return performer;
    }

    public void setPerfomer(String performer) {
        this.performer = performer;
    }

    public void addAlbum(Album alb) {
        if (albums==null) albums = new HashMap();
        albums.put(alb.getAlbum(), alb);
    }
    
    public HashMap<String,Album> getAlbums() {
        if (albums==null) albums = new HashMap();
        return albums;
    }

    public void setAlbums(HashMap<String,Album> albums) {
        this.albums = albums;
    }
    
}
