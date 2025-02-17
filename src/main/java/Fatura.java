package sistemas_distribuidos_java.src.main.java;

public import java.io.Serializable;

public class Fatura implements Serializable {
    private Cliente cliente;
    private double valor;

    public Fatura(Cliente cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Fatura{cliente=" + cliente.getNome() + ", valor=" + valor + "}";
    }
}
 {
    
}
