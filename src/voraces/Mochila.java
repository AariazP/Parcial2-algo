package voraces;

import java.util.ArrayList;
import java.util.Comparator;

public class Mochila {


    public static void main(String[] args) {
        Mochila mochila = new Mochila();
        ArrayList<Objeto> objetos = new ArrayList<>();
        int tamanioMochila = 100;

        Objeto objeto1 = new Objeto(10,10,1);
        Objeto objeto2 = new Objeto(20,30,1);
        Objeto objeto3 = new Objeto(30,66,1);
        Objeto objeto4 = new Objeto(40,40,1);
        Objeto objeto5 = new Objeto(50,60,1);

        objetos.add(objeto1);
        objetos.add(objeto2);
        objetos.add(objeto3);
        objetos.add(objeto4);
        objetos.add(objeto5);

        //ordenar por peso
        //objetos.sort(Comparator.comparingInt(Objeto::getPeso).reversed());

        ArrayList<Objeto> mochilaPeso = mochila.mochilaPeso(objetos, tamanioMochila);
        System.out.println("mochila que lleva los objetos más pesados \n" + mochilaPeso);

        //ordenar por valor
        //objetos.sort(Comparator.comparingInt(Objeto::getValor).reversed());
        ArrayList<Objeto> mochilaValor= mochila.mochilaValor(objetos, tamanioMochila);
        System.out.println(" Mochila que lleva los objetos más valiosos \n"+ mochilaValor);


        objetos.sort(Comparator.comparingDouble(Objeto::getRelacion).reversed());
        ArrayList<Objeto> mochilaRelacion=mochila.mochilaRelacion(objetos, tamanioMochila);
        System.out.println("Los mejores objetos con relación valor/peso \n"+mochilaRelacion);
    }

    private ArrayList<Objeto> mochilaRelacion(ArrayList<Objeto> objetos, int tamanioMochila) {
        ArrayList<Objeto> mochilaRelacion = new ArrayList<>();

        for(Objeto obj:objetos){

            if(obj.getPeso()<tamanioMochila){

                mochilaRelacion.add(obj);
                tamanioMochila-=obj.getPeso();
            }


        }

        return mochilaRelacion;

    }

    private ArrayList<Objeto> mochilaValor(ArrayList<Objeto> objetos, int tamanioMochila) {
        ArrayList<Objeto> mochilaValor=new ArrayList<>();

        for(Objeto obj:objetos){

            if(obj.getPeso()<=tamanioMochila){
                mochilaValor.add(obj);
                tamanioMochila-=obj.getPeso();
            }

        }

        return mochilaValor;
    }

    private ArrayList<Objeto> mochilaPeso(ArrayList<Objeto> objetos, int tamanioMochila) {
        ArrayList<Objeto> mochila = new ArrayList<>();


        for(Objeto obj: objetos){

            if(obj.getPeso()<=tamanioMochila){
                mochila.add(obj);
                tamanioMochila -= obj.getPeso();
            }


        }

        return mochila;

    }
}
