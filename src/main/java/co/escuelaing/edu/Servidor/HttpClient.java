package co.escuelaing.edu.Servidor;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


 /**
   * Clase Cliente para probar el funcionamiento del 
   * Servidor Concurrente
   *
   * 
   */
public class HttpClient {

    public static void main(String[] args) throws IOException {
        
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        for(int i=0;i<15;i++){
        try {
            
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
        
        
        

            System.out.println("echo: " + in);
            
        out.close();
        in.close();
        echoSocket.close();
        }
    }
}
