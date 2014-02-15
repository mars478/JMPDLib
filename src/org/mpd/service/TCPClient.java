package org.mpd.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mars
 */

public class TCPClient {
 
    private static final boolean DEBUG = false;
    
    private static TCPClient tcpClient = null;
    private static Socket socket = null;
    private static PrintWriter out = null;
    private static BufferedReader in = null;
    
    private TCPClient(String host, int port) {
        try {
            socket = new Socket(host,port);
            out=new PrintWriter(socket.getOutputStream(), true); 
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
            socket = null;
            in = null;
            out = null;
        }
    };
    
    private TCPClient() {};
    
    public static TCPClient getTCPClient(String host, int port) throws Exception {
        tcpClient = new TCPClient(host,port);
        if (socket != null) return tcpClient;
        throw new Exception("TCP Client error: unable to connect to " + host + ":" + port + ".");
    }
    
    public static TCPClient getTCPClient () throws Exception {
        if (socket != null) return tcpClient;
        throw new Exception("TCP Client error: null socket.");
    }
    
    public ArrayList<String> doSingleRequest(String request) {
        ArrayList<String> al = new ArrayList();
        al.add(request+"\n");
        return this.doRequest(al);
    }
    
    public ArrayList<String> doRequest(ArrayList<String> request) {
    
        ArrayList<String> response = null;

        try {
            response = new ArrayList();
            Iterator<String> iter = request.iterator();
            while(iter.hasNext()){
                out.write(iter.next()); 
                out.flush();
                }    

            String temp;
            while ((temp = in.readLine()) != null) { 
                if (DEBUG) System.out.println("Server: " + temp);
                response.add(temp);
                if (temp.equals("OK")) break; // request passed
                if (temp.contains("ACK [")) break; //request failed
                }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }
    
    public void closeConn(){
        try{
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
