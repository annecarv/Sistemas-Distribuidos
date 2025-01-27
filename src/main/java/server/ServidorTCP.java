package main.java.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) {
        int porta = 6002;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor aguardando conexões...");

            try (Socket socket = serverSocket.accept(); 
                InputStream inputStream = socket.getInputStream()) {

                int numeroClientes = inputStream.read();
                System.out.println("Número de clientes: " + numeroClientes);
            } catch (IOException e) {
                System.err.println("Erro ao processar o cliente: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
