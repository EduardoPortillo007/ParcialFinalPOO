package servidorcuadrado;


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
public class ManejadorCliente {

    private Socket  socketCliente;

    public ManejadorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    
   public void run() {
        try {

            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            String msg = reader.readLine();
            System.out.println("Mensaje del cliente: " + msg);
            writer.println("Hola," + msg+ "");
            socketCliente.close();

        } catch (IOException e) {

        }
    }
    
}
