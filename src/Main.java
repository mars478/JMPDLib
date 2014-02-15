
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
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
            /*
            Scanner scan = new Scanner(System.in);
            String s;
            System.out.println("Ready:");
            while ((s = scan.nextLine())!="-1"){
                resp = mpd.request(s);
                System.out.println("Size:"+resp.size());
                Iterator<String> iter = resp.iterator();
                while(iter.hasNext()){
                    String str = iter.next();
                    System.out.println("Resp: "+str);
                    }
            } */
        }
        mpd.closeConn();     
        
    }
}
