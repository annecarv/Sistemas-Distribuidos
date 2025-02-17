package sistemas_distribuidos_java.src.main.java;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private PlanoTV plano;
    private Endereco endereco;

    public Cliente(String nome, PlanoTV plano, Endereco endereco) {
        this.nome = nome;
        this.plano = plano;
        this.endereco = endereco;
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
