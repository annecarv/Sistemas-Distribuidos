package sd_project.sistemas_distribuidos_java.src.main.java;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class PlanoTVServiceImpl extends UnicastRemoteObject implements PlanoTVService {

    public PlanoTVServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Fatura gerarFatura(Cliente cliente) throws RemoteException {
        double valor = cliente.getPlano();
        return new Fatura(cliente, valor);
    }

    @Override
    public PlanoTV criarPlano(String nome, double preco, int canais) throws RemoteException {
        return new PlanoTV(nome, preco, canais);
    }

    @Override
    public Cliente cadastrarCliente(String nome, PlanoTV plano, Endereco endereco) throws RemoteException {
        return new Cliente(nome, plano, endereco);
    }

    @Override
    public void atualizarPlanoCliente(Cliente cliente, PlanoTV novoPlano) throws RemoteException {
        cliente.setPlano(novoPlano);
    }
}
