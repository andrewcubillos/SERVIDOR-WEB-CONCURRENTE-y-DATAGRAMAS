package co.escuelaing.edu.datagramas;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DatagramTimeClient {
    private static String temp;

    
public static void main(String[] args) {
        byte[] sendBuf = new byte[256];
        boolean running= true;
        while(running){
        try {
            DatagramSocket socket = new DatagramSocket();
            
            byte[] buf = new byte[256];
           
            
            
                InetAddress address = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
                socket.send(packet);
                
                packet = new DatagramPacket(buf, buf.length);
                 socket.setSoTimeout(6000);
                socket.receive(packet);
                
                String received = new String(packet.getData(), 0, packet.getLength());
                temp=received;
                System.out.println("Date: " + received);
            
        }catch(SocketTimeoutException ex){
            System.out.println("Date: "+temp);
            
            
        } catch (SocketException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
}
