package sd_project.sistemas_distribuidos_java.src.main.java;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private PlanoTV plano;
    private Endereco endereco;
    private String cpf;


    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cliente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private int idade;

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PlanoTV getPlano() {
        return plano;
    }

    public void setPlano(PlanoTV plano) {
        this.plano = plano;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{nome=" + nome + ", plano=" + plano + ", endereco=" + endereco + "}";
    }
}
