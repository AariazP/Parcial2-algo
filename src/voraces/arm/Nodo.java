package voraces.arm;

import java.util.ArrayList;

public class Nodo {

    private ArrayList<Arista> aristas;
    private String nombre;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<>();
    }


    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }

    public void addArista(Arista a1) {
        aristas.add(a1);
    }

    @Override
    public String toString() {
        return "Nodo{" +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
