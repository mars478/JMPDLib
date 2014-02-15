package org.mpd.entities;

import java.util.ArrayList;

/**
 *
 * @author mars
 */
public class Album {
    private String url;
    private String performer;
    private String album;
    private String genre;
    private int totalTracks;
    private ArrayList<Track> tracks;

    public Album(){}
    
    public Album(String album){
        this.album = album;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(int totalTracks) {
        this.totalTracks = totalTracks;
    }

    public ArrayList<Track> getTracks() {
        if (tracks==null) tracks = new ArrayList();
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }
    
    
}
