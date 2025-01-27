package main.java;

public class PlanoTV {
    private String nomePlano;
    private int quantidadeCanais;
    private double valorMensal;

    public PlanoTV(String nomePlano, int quantidadeCanais, double valorMensal) {
        this.nomePlano = nomePlano;
        this.quantidadeCanais = quantidadeCanais;
        this.valorMensal = valorMensal;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public int getQuantidadeCanais() {
        return quantidadeCanais;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    @Override
    public String toString() {
        return "Plano: " + nomePlano + ", Canais: " + quantidadeCanais + ", Valor: R$ " + valorMensal;
    }

}
