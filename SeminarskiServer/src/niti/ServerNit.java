/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanja
 */
public class ServerNit extends Thread{

    private ServerSocket serverSocket;
    private List<KlijentNit> listaKlijentNiti;

    public ServerNit() throws Exception{
        serverSocket = new ServerSocket(10000);
        listaKlijentNiti = new LinkedList<>();
    }
    
    
    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                KlijentNit klijentNit = new KlijentNit(socket);
                klijentNit.start();
                listaKlijentNiti.add(klijentNit);
            }
        } catch (Exception ex) {
            
        }

    }

    public void zaustaviServer() {
        try {
            for(KlijentNit kn: listaKlijentNiti){
                kn.ugasiKlijenta();
            }
            serverSocket.close();
            
        } catch (IOException ex) {
            
        }
    }
    
    
}
