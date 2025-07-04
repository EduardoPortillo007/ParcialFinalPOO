/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidorcuadrado;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;

public class ServidorCuadrado {

    
    public static void main(String[] args) {
        try{          
            ServerSocket serverSo = new ServerSocket(5000);
           
            while(true){
            System.out.println("Esperando la conexión");
            Socket socketCl = serverSo.accept();
            System.out.println("Cliente conectado: "+ socketCl.getInetAddress());
           
            InputStream inputStream = socketCl.getInputStream();
            OutputStream outputStream = socketCl.getOutputStream();
           
            BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter write = new PrintWriter(outputStream, true);
           
            String msg = read.readLine();
            System.out.println("Mensaje cliente: "+msg);
            write.println("Este mensaje se ha enviado desde el servidor");
            socketCl.close();
            serverSo.close();
            }
        }catch(IOException e){
           
        }
    }
    
}
