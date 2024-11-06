package voraces.arm;

import java.util.ArrayList;
import java.util.Comparator;

public class Arm {


    public static void main(String[] args) {

        Nodo nodoA = new Nodo("A");
        Nodo nodoB = new Nodo("B");
        Nodo nodoC = new Nodo("C");
        Nodo nodoD = new Nodo("D");
        Nodo nodoE = new Nodo("E");
        Nodo nodoF = new Nodo("F");
        Nodo nodoG = new Nodo("G");
        Nodo nodoH = new Nodo("H");
        Nodo nodoI = new Nodo("I");

        // Crear aristas con los pesos según la imagen
        Arista a1 = new Arista(nodoA, nodoB, 6);
        Arista a2 = new Arista(nodoA, nodoD, 10);
        Arista a3 = new Arista(nodoA, nodoE, 8);
        Arista a4 = new Arista(nodoB, nodoC, 11);
        Arista a5 = new Arista(nodoB, nodoG, 15);
        Arista a6 = new Arista(nodoC, nodoH, 3);
        Arista a7 = new Arista(nodoD, nodoE, 6);
        Arista a8 = new Arista(nodoE, nodoF, 2);
        Arista a9 = new Arista(nodoF, nodoG, 4);
        Arista a10 = new Arista(nodoG, nodoH, 5);
        Arista a11 = new Arista(nodoG, nodoI, 6);
        Arista a12 = new Arista(nodoH, nodoI, 7);
        Arista a13 = new Arista(nodoB, nodoH, 13);


        // Agregar aristas a los nodos
        nodoA.addArista(a1);
        nodoA.addArista(a2);
        nodoA.addArista(a3);

        nodoB.addArista(a1);
        nodoB.addArista(a4);
        nodoB.addArista(a5);
        nodoB.addArista(a13);

        nodoC.addArista(a4);
        nodoC.addArista(a6);

        nodoD.addArista(a2);
        nodoD.addArista(a7);

        nodoE.addArista(a3);
        nodoE.addArista(a7);
        nodoE.addArista(a8);

        nodoF.addArista(a8);
        nodoF.addArista(a9);

        nodoG.addArista(a5);
        nodoG.addArista(a9);
        nodoG.addArista(a10);
        nodoG.addArista(a11);

        nodoH.addArista(a6);
        nodoH.addArista(a10);
        nodoH.addArista(a12);
        nodoH.addArista(a13);

        nodoI.addArista(a11);
        nodoI.addArista(a12);

        // Crear listas de nodos y aristas
        ArrayList<Nodo> nodos = new ArrayList<>();
        nodos.add(nodoA);
        nodos.add(nodoB);
        nodos.add(nodoC);
        nodos.add(nodoD);
        nodos.add(nodoE);
        nodos.add(nodoF);
        nodos.add(nodoG);
        nodos.add(nodoH);
        nodos.add(nodoI);

        ArrayList<Arista> aristas = new ArrayList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        aristas.add(a9);
        aristas.add(a10);
        aristas.add(a11);
        aristas.add(a12);
        aristas.add(a13);

        Arm arm = new Arm();
        ArrayList<Arista> result = arm.kruskal(nodos, aristas);
        System.out.println("Total de nodos " + result.size());
        System.out.println("result = " + result);
    }

    private ArrayList<Arista> kruskal(ArrayList<Nodo> nodos, ArrayList<Arista> aristas) {

        ArrayList<Arista> result = new ArrayList<>();
        ArrayList<Nodo> nodosResult = new ArrayList<>();
        aristas.sort(Comparator.comparingInt(Arista::getPeso));

        while(!tieneTodosNodos(result, nodos)){

            Arista arista = aristas.getFirst();
            if(!tieneCiclo(arista, nodosResult)){
                if(!nodosResult.contains(arista.getNodo1())){
                    nodosResult.add(arista.getNodo1());
                    result.add(arista);
                    aristas.remove(arista);
                }else{
                    nodosResult.add(arista.getNodo2());
                    result.add(arista);
                    aristas.remove(arista);
                }
            }

        }

        return result;
    }

    private boolean tieneTodosNodos(ArrayList<Arista> result, ArrayList<Nodo> nodos) {

        ArrayList<Nodo> nodosAux = (ArrayList<Nodo>) nodos.clone();
        for(Arista arista:result){
            Nodo nodo1 = arista.getNodo1();
            Nodo nodo2 = arista.getNodo2();
            nodosAux.remove(nodo1);
            nodosAux.remove(nodo2);
        }

        return nodosAux.isEmpty();
    }

    private boolean tieneCiclo(Arista edge, ArrayList<Nodo> nodos) {
        return nodos.contains(edge.getNodo1()) && nodos.contains(edge.getNodo2());
    }

}
