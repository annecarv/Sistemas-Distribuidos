package main.java;

import java.io.*;
import java.util.Scanner;

public class ClientesInputStream extends InputStream {
    private final InputStream origem;

    public ClientesInputStream(InputStream origem) {
        this.origem = origem;
    }

    @Override
    public int read() throws IOException {
        return origem.read();
    }

    public Cliente lerCliente(String linha) {
        try {
            String[] dados = linha.split(",");
            if (dados.length < 4) { 
                throw new IllegalArgumentException("Formato de dados inválido: " + linha);
            }
    
            String nomeCliente = dados[0].trim();
            String cpf = dados[1].trim().replaceAll("[^0-9]", "");
            if (cpf.length() != 11) {
                throw new IllegalArgumentException("CPF inválido: " + dados[1]);
            }
    
            int idade = Integer.parseInt(dados[2].trim());
            String nomePlano = dados[3].trim();
            if (nomePlano.startsWith("Plano:")) { 
                nomePlano = nomePlano.split(":")[1].trim();
            }
    
            // Criar objetos
            PlanoTV plano = !nomePlano.equalsIgnoreCase("Nenhum") ? new PlanoTV(nomePlano, 0, 0) : null;
            Cliente cliente = new Cliente(nomeCliente, cpf, idade);
    
            if (plano != null) {
                cliente.contratarPlano(plano);
            }
    
            return cliente;
    
        } catch (Exception e) {
            System.err.println("Erro ao processar linha: " + linha + " - " + e.getMessage());
            return null;
        }
    }

    public static void salvarClienteEmArquivo(Cliente cliente, String caminhoArquivo) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write(cliente.getNomeCliente() + "," + cliente.getCpf() + "," + cliente.getIdade() + "," + cliente.getPlanoContratado());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao salvar cliente no arquivo: " + e.getMessage());
        }
    }

    @Override
    public void close() throws IOException {
        origem.close();
    }

    public static void main(String[] args) {
        String caminhoArquivo = "/Users/enniax/Documents/sistemas_distribuidos_java/src/main/java/data/clientes_cadastro.txt"; 
    
        System.out.println("Bem-vindo ao sistema de cadastro de clientes!");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuarCadastro = true;

            while (continuarCadastro) {
                System.out.println("Digite os dados do cliente: Nome,CPF,Idade,Plano");
                System.out.println("Exemplo: Maria,123.456.789-00,30,Básico");

                String entrada = scanner.nextLine().trim();
 
                try (ClientesInputStream cis = new ClientesInputStream(new ByteArrayInputStream(entrada.getBytes()))) {
                    Cliente cliente = cis.lerCliente(entrada);
                    if (cliente != null) {
                        System.out.println(cliente.getNomeCliente() + " - " + cliente.getCpf());
                        System.out.println("Cliente Cadastrado!");

                        salvarClienteEmArquivo(cliente, caminhoArquivo);
                    } else {
                        System.out.println("Não foi possível cadastrar o cliente. Tente novamente.");
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao processar entrada: " + e.getMessage());
                }

                System.out.println("Deseja continuar cadastrando mais clientes? (s/n)");
                String resposta = scanner.nextLine().trim().toLowerCase();

                if (!resposta.equals("s")) {
                    continuarCadastro = false;
                    System.out.println("Cadastro encerrado.");
                }
            }

            // Teste com arquivo
            try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
                System.out.println("Lendo dados do arquivo..." + caminhoArquivo);
                String linha;
                while ((linha = reader.readLine()) != null) {
                    try (ClientesInputStream cis = new ClientesInputStream(new ByteArrayInputStream(linha.getBytes()))) {
                        Cliente cliente = cis.lerCliente(linha);
                        if (cliente != null) {
                            System.out.println(cliente.getNomeCliente() + " - " + cliente.getCpf());
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Arquivo não encontrado. Path:" + caminhoArquivo);
            } catch (IOException e) {
                System.err.println("Erro ao ler arquivo. Path:" + caminhoArquivo + e.getMessage());
            }
        }
    }
}
