package voraces;

import java.util.ArrayList;
import java.util.Comparator;

public class MochilaFraccionada {


    public static void main(String[] args) {
        MochilaFraccionada mochila = new MochilaFraccionada();
        ArrayList<Objeto> objetos = new ArrayList<>();
        int tamanioMochila = 100;

        Objeto objeto1 = new Objeto(20,10,1);
        Objeto objeto2 = new Objeto(30,20,1);
        Objeto objeto3 = new Objeto(66,30,1);
        Objeto objeto4 = new Objeto(40,40,1);
        Objeto objeto5 = new Objeto(60,50,1);

        objetos.add(objeto1);
        objetos.add(objeto2);
        objetos.add(objeto3);
        objetos.add(objeto4);
        objetos.add(objeto5);

        objetos.sort(Comparator.comparingDouble(Objeto::getRelacion).reversed());
        ArrayList<Objeto> mochilaRelación = mochila.mochilaRelacion(objetos, tamanioMochila);

        System.out.println("mochilaRelación = " + mochilaRelación);


    }

    private ArrayList<Objeto> mochilaRelacion(ArrayList<Objeto> objetos, int tamanioMochila) {

        ArrayList<Objeto> mochila = new ArrayList<>();


        for(Objeto obj:objetos){

            if(tamanioMochila==0) break;
            else if(obj.getPeso()<tamanioMochila){
                mochila.add(obj);
                tamanioMochila-=obj.getPeso();
            }else{
                double relacion = tamanioMochila/obj.getPeso();
                obj.setCantidad(obj.getCantidad()*relacion);
                obj.setPeso(obj.getPeso()*relacion);
                obj.setValor(obj.getValor()*relacion);
                mochila.add(obj);
                tamanioMochila = 0;
            }

        }

        return mochila;

    }


}
