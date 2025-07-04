package ImplementacionCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author eloga
 */
public class ClienteCuadrado {
     public static void main(String[] args) {
        
   
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Se conecto al servidor");
            //flujo de entrada y salida
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            //enviar mensaje
            writer.println("");
            //enviar mensaje al server
            String res = reader.readLine();
            System.out.println("Respuesta del servidor: " + res);
            socket.close();

        } catch (IOException e) {

            System.out.println(e);
        }
    }
    
    
}


