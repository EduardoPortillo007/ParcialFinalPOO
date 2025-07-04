package ImplementacionCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author eloga
 */
public class ClienteCuadrado {
     public static void main(String[] args) {
        String host = "localhost";
        int puerto = 5000;

        try (
            Socket socket = new Socket(host, puerto);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
        ) {
            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese un número entero: ");
            int numero = scanner.nextInt();

            salida.println(nombre);
            salida.println(numero);

            for(int i=0; i<3 ; i++) {
                String respuesta = entrada.readLine();
                System.out.println(respuesta);
            }

        } catch (IOException e) {

            System.out.println(e);
        }
    }
    
    
}


