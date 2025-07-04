package servidorcuadrado;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author eloga
 */
public class ManejadorCliente implements Runnable{

    private Socket socket;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String nombre = entrada.readLine();
            int numero = Integer.parseInt(entrada.readLine());

            System.out.println("Cliente " + nombre + " conectado.");

            int cuadrado = numero * numero;
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            salida.println("Bienvenido, " + nombre);
            salida.println("El cuadrado de " + numero + " es: " + cuadrado);
            salida.println("Fecha y hora del servidor: " + fechaHora);

            System.out.println("Cliente " + nombre + " desconectado.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
