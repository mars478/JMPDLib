
import java.util.ArrayList;
import org.mpd.client.MPDClient;
import org.mpd.client.MPDLibrary;

/**
 *
 * @author mars
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        ArrayList<String> resp = new ArrayList();
        
        MPDClient mpd = new MPDClient();
        if (mpd.setConnection("192.168.88.88", 6600)) {              
            mpd.handshake();
            
            
            MPDLibrary mLib = new MPDLibrary();
            mLib.setMPDClient(mpd);
            mLib.listAllInfo();
            mLib.showTree();
        }
        mpd.closeConn();     
        
    }
}
