package org.mpd.client;

import java.util.ArrayList;
import java.util.Iterator;
import org.mpd.service.TCPClient;

/**
 *
 * @author mars
 */
public class MPDClient {
    
    private TCPClient tcpClient;
    
    public MPDClient() {};
    
    public boolean setConnection(String host, int port) {
        try {
            tcpClient = TCPClient.getTCPClient(host, port);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean handshake(){
        ArrayList<String> request = new ArrayList();
        request.add("status\n");
        ArrayList resp = tcpClient.doRequest(request);
        if ((resp == null) || (resp.isEmpty())) return false;
        return true;
    }
    
    public ArrayList<String> request(String request){
        if (request == null) return null;
        return tcpClient.doSingleRequest(request);
    }
    
    public ArrayList<String> request(ArrayList<String> request){
        if ((request==null)||(request.isEmpty())) return null;
        return tcpClient.doRequest(request);
    }
    
    public void closeConn(){
        tcpClient.closeConn();
    }
    
}
