/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidorcuadrado;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCuadrado {

    
    public static void main(String[] args) {
        int puerto = 5000;
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado en el puerto " + puerto);
            while (true) {
                Socket socketCliente = servidor.accept();
                Thread hilo = new Thread(new ManejadorCliente(socketCliente));
                hilo.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
