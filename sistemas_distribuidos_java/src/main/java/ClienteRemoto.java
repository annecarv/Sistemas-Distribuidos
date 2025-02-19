package sd_project.sistemas_distribuidos_java.src.main.java;

import java.rmi.Naming;

public class ClienteRemoto {

    public static void main(String[] args) {
        try {
            PlanoTVService service = (PlanoTVService) Naming.lookup("rmi://localhost/PlanoTVService");

            // Criação de objetos POJOs
            PlanoTV plano = service.criarPlano("Plano Básico", 99.99, 50);
            Endereco endereco = new Endereco("Rua A", "Cidade X", "Estado Y", "12345-678");
            Cliente cliente = service.cadastrarCliente("João", plano, endereco);

            Fatura fatura = service.gerarFatura(cliente);
            System.out.println(fatura);

            PlanoTV novoPlano = service.criarPlano("Plano Premium", 199.99, 100);
            service.atualizarPlanoCliente(cliente, novoPlano);

            System.out.println("Plano atualizado: " + cliente.getPlano());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
