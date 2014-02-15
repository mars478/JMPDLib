package org.mpd.entities;

/**
 *
 * @author mars
 */

/*

stats

artists: 0
albums: 0
songs: 0
uptime: 11897
playtime: 11
db_playtime: 0
db_update: 1387878206
OK

*/
public class Stats {
    private long artists;
    private long albums;
    private long songs;

    public long getArtists() {
        return artists;
    }

    public void setArtists(long artists) {
        this.artists = artists;
    }

    public long getAlbums() {
        return albums;
    }

    public void setAlbums(long albums) {
        this.albums = albums;
    }

    public long getSongs() {
        return songs;
    }

    public void setSongs(long songs) {
        this.songs = songs;
    }
}
