package org.mpd.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.mpd.entities.Album;
import org.mpd.entities.Performer;
import org.mpd.entities.Track;

/**
 *
 * @author mars
 */
public class MPDLibrary {
    
    MPDClient mpd;
    HashMap<String,Performer> performers;
    HashMap<String,Album> albums;
    ArrayList<Track> tracks;
    
    public MPDLibrary(){}
    
    public void setMPDClient(MPDClient mpd){
        this.mpd = mpd;
    }
    
    public MPDClient getMPDClient(){
        return mpd;
    }
    
    public void listAllInfo(){
        
        ArrayList<String> response = mpd.request("listallinfo\n");
        Track trck = null;
        
        // first pass parsing (tracks)
        tracks = new ArrayList();
        Iterator<String> iter = response.iterator();
        while(iter.hasNext()){ 
            
            String str = iter.next();
            
            if (str.contains("file:")){
                if (trck!=null) tracks.add(trck);
                trck = new Track();
                trck.setUrl(str.replace("file: ", ""));
            } else if ((trck!=null) && (str.startsWith("Time:"))){
                trck.setTime(Long.parseLong(str.replace("Time: ", "")));
            } else if ((trck!=null) && (str.startsWith("Artist: "))){
                trck.setPerfomer(str.replace("Artist: ", ""));
            } else if ((trck!=null) && (str.startsWith("Title:"))){
                trck.setTrack(str.replace("Title: ", ""));
            } else if ((trck!=null) && (str.startsWith("Album:"))){
                trck.setAlbum(str.replace("Album: ", ""));
            } else if ((trck!=null) && (str.contains("Track:"))){
                String st = str.replace("Track: ", "");
                int separator = st.lastIndexOf("/");
                if (separator !=-1){
                    trck.setNumber(Integer.parseInt(st.subSequence(0, st.lastIndexOf("/")).toString()));
                    trck.setTotalNumber(Integer.parseInt(st.subSequence(st.lastIndexOf("/")+1, st.length()).toString()));
                }
                else
                    trck.setNumber(Integer.parseInt(st));
            } else if ((trck!=null) && (str.contains("Date:"))){
                trck.setDescription(str.replace("Date: ", ""));
            } 
        } //end of first pass
        
        //second pass - albums
        albums = new HashMap();
        Iterator<Track> iterT = tracks.iterator();
        while(iterT.hasNext()){
            Track tr = iterT.next();
            String pf = tr.getPerfomer();
            String al = tr.getAlbum();
            
            if (!albums.containsKey(al+"#$#"+pf))
                albums.put(al+"#$#"+pf, new Album(al));
            }
        iterT = tracks.listIterator(0);
        while(iterT.hasNext()){
            Track tr = iterT.next();
            String pf = tr.getPerfomer();
            String al = tr.getAlbum();
            
            Album tempA = albums.get(al+"#$#"+pf);
            tempA.getTracks().add(tr);
            tempA.setPerformer(pf);
        } //end of second pass
        
        //third pass - perfomers
        performers = new HashMap();
        for (String ap:albums.keySet()){
            Album alb = albums.get(ap);
            String performer = ap.substring(ap.indexOf("#$#")+3,ap.length());
            if (!performers.containsKey(performer))
                performers.put(performer, new Performer(performer));
        }
        for (String ap:albums.keySet()){
            Album alb = albums.get(ap);
            String album = ap.substring(0,ap.indexOf("#$#"));
            String performer = ap.substring(ap.indexOf("#$#")+3,ap.length());
            
            performers.get(performer).addAlbum(alb);
        }
        //end of third pass
    }
    
    public void showTree(){
        System.out.println();
        System.out.println("showTree():");
        
        for (String pf:performers.keySet()){
            Performer prf = performers.get(pf);
            System.out.println(prf.getPerfomer());
            
            for (String st:prf.getAlbums().keySet()){
                Album alb = prf.getAlbums().get(st);
                System.out.println("\t"+alb.getAlbum());
                
                Iterator<Track> iterT = alb.getTracks().iterator();
                    while(iterT.hasNext()){
                        Track tr = iterT.next();
                        System.out.println("\t\t" + tr.getNumber() + "." + tr.getTrack() + " : " + tr.getUrl());
                        }
            }
        }    
        
        /*
        for (String strk:performers.keySet()){
            }
            
        }*/
    } 
}

/*
file: USB/?????????/2004 - ? ?????/01 - ????.mp3
Server: Last-Modified: 2013-08-08T22:02:48Z
Server: Time: 183
Server: Artist: Грета
Server: Title: Блюз
Server: Album: Я дошёл
Server: Track: 01/35
Server: Date: 2004
*/