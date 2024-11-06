package misterio;

import java.util.ArrayList;
import java.util.Comparator;

public class Mochila {

    public static void main(String[] args) {
        Mochila mochila = new Mochila();

        Persona juan = new Persona(20, 5);
        Persona andrew = new Persona(9, 3);
        Persona mary = new Persona(7, 5);
        Persona ada = new Persona(8, 2);
        Persona steve = new Persona(15, 4);
        Persona grace = new Persona(17, 3);
        Persona richard = new Persona(13, 4);
        Persona william = new Persona(10, 3);

        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(juan);
        personas.add(andrew);
        personas.add(mary);
        personas.add(ada);
        personas.add(steve);
        personas.add(grace);
        personas.add(richard);
        personas.add(william);

        personas.sort(Comparator.comparingDouble(Persona::getSvc).reversed());

        System.out.println(mochila.calcularMejorEleccion(personas));
    }

    private ArrayList<Persona> calcularMejorEleccion(ArrayList<Persona> personas) {

        ArrayList<Persona> result = new ArrayList<>();
        int dinero = 70;

        for(Persona p:personas){

            if(p.getSalario()<=dinero){
                dinero-=p.getSalario();
                result.add(p);
            }

        }
        System.out.println("dinero = " + dinero);
        return result;
    }


}
