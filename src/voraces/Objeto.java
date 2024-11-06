package voraces;

import java.util.Comparator;

public class Objeto {
    private double valor;
    private double peso;
    private double cantidad;
    private double relacion;

    public Objeto(double valor, double peso, int cantidad) {
        this.valor = valor;
        this.peso = peso;
        this.cantidad = cantidad;
        this.relacion = valor/peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "valor=" + valor +
                ", peso=" + peso +
                ", cantidad=" + cantidad +
                '}';
    }

    public double getRelacion() {
        return relacion;
    }

    public void setRelacion(double relacion) {
        this.relacion = relacion;
    }
}
