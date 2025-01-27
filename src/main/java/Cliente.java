package main.java;

public class Cliente {
    private String nomeCliente;
    private String cpf;
    private int idade;
    private PlanoTV planoContratado;

        public Cliente(String nomeCliente, String cpf, int idade) {
            this.nomeCliente = nomeCliente;
            this.cpf = cpf;
            this.idade = idade;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public PlanoTV getPlanoContratado() {
        return planoContratado;
    }

    public void contratarPlano(PlanoTV plano) {
        this.planoContratado = plano;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente + ", CPF: " + cpf + ", Plano: " + (planoContratado != null ? planoContratado.getNomePlano() : "Nenhum");
    }
}