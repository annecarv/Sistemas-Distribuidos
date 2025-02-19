package sd_project.sistemas_distribuidos_java.src.main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PlanoTVService extends Remote {
    public Fatura gerarFatura(Cliente cliente) throws RemoteException;
    public PlanoTV criarPlano(String nome, double preco, int canais) throws RemoteException;
    public Cliente cadastrarCliente(String nome, PlanoTV plano, Endereco endereco) throws RemoteException;
    public void atualizarPlanoCliente(Cliente cliente, PlanoTV novoPlano) throws RemoteException;
}
