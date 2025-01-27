package main.java;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClientesOutputStream extends OutputStream {
    private final OutputStream destino;

    public ClientesOutputStream(OutputStream destino) {
        this.destino = destino;
    }

    @Override
    public void write(int b) throws IOException {
        destino.write(b);
    }

    public void enviarClientes(Cliente[] clientes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(destino));
        for (Cliente cliente : clientes) {
            String linha = String.format("%s,%s,%d,%s", cliente.getNomeCliente(), cliente.getCpf(), cliente.getIdade(), cliente.getPlanoContratado() != null ? cliente.getPlanoContratado().getNomePlano() : "Nenhum");
            writer.write(linha);
            writer.newLine();
        }
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        destino.close();
    }

    public static void main(String[] args) {
        try {
            PlanoTV planoBasico = new PlanoTV("Básico", 100, 90);
            PlanoTV planoAvancado = new PlanoTV("Premium", 500, 130);

            Cliente[] clientes = {
                new Cliente("Maria", "123.456.789-00", 30),
                new Cliente("Eduarda", "987.654.321-11", 25),
                new Cliente("Anne", "111.222.333-44", 20)
            };

            clientes[0].contratarPlano(planoBasico);
            clientes[1].contratarPlano(planoAvancado);

            File arquivo = new File("/Users/enniax/Documents/sistemas_distribuidos_java/src/main/java/data/clientes_input.txt");
            System.out.println("Enviando dados para o arquivo: " + arquivo.getName());
            try (ClientesOutputStream cos = new ClientesOutputStream(new FileOutputStream(arquivo))) {
                cos.enviarClientes(clientes);
            }
            System.out.println("Dados enviados com sucesso para o arquivo!");

            System.out.println("\nEnviando dados para a saída padrão:");
            try (ClientesOutputStream cos = new ClientesOutputStream(System.out)) {
                cos.enviarClientes(clientes);
            }
        } catch (IOException e) {
            System.err.println("Erro ao enviar os dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
