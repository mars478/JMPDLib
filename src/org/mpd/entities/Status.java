package org.mpd.entities;

/**
 *
 * @author mars
 */

/*
status

volume: 41
repeat: 0
random: 1
single: 0
consume: 0
playlist: 47
playlistlength: 0
xfade: 0
mixrampdb: 0.000000
mixrampdelay: nan
state: stop
OK

song:  playlist song number of the current song stopped on or playing 
songid: playlist songid of the current song stopped on or playing 
nextsong: [2]  playlist song number of the next song to be played 
nextsongid: [2] playlist songid of the next song to be played 
time: total time elapsed (of current playing/paused song)
bitrate: instantaneous bitrate in kbps
*/
public class Status {

    private int volume;
    private int repeat;
    private int random;
    private int single;
    private int consume;
    private int playlist;
    private long playlistLength;
    private String state;
    
    private long song;
    private long songId;
    private long nextSong;
    private long nextSongId;
    private long time;
    private long bitrate;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public int getSingle() {
        return single;
    }

    public void setSingle(int single) {
        this.single = single;
    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public int getPlaylist() {
        return playlist;
    }

    public void setPlaylist(int playlist) {
        this.playlist = playlist;
    }

    public long getPlaylistLength() {
        return playlistLength;
    }

    public void setPlaylistLength(long playlistLength) {
        this.playlistLength = playlistLength;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getSong() {
        return song;
    }

    public void setSong(long song) {
        this.song = song;
    }

    public long getSongId() {
        return songId;
    }

    public void setSongId(long songId) {
        this.songId = songId;
    }

    public long getNextSong() {
        return nextSong;
    }

    public void setNextSong(long nextSong) {
        this.nextSong = nextSong;
    }

    public long getNextSongId() {
        return nextSongId;
    }

    public void setNextSongId(long nextSongId) {
        this.nextSongId = nextSongId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getBitrate() {
        return bitrate;
    }

    public void setBitrate(long bitrate) {
        this.bitrate = bitrate;
    }
    
}
