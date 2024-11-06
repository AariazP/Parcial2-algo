package voraces;

import java.util.HashMap;
import java.util.Map;

public class Devuelta {

    public static void main(String[] args) {
        HashMap<Integer, Integer> monedas = new HashMap<>();
        int[][] caja = new int[2][3];
        caja[0][0] = 200;
        caja[1][0] = 10;
        caja[0][1] = 100;
        caja[1][1] = 4;
        caja[0][2] = 50;
        caja[1][2] = 2;
        int devuelta=1900;
        Devuelta devuelta1 = new Devuelta();
        System.out.println(devuelta1.calcularDevuelta(caja, devuelta));
    }

    public Map<Integer, Integer> calcularDevuelta(int[][] caja, int devuelta){

        HashMap<Integer, Integer> cantidadDevuelta = new HashMap<>();
        int i = 0;
        while (i<caja[0].length){

            if(devuelta == 0) break;
            else if(caja[0][i]<=devuelta && caja[1][i]>0){
                int moneda = caja[0][i];
                if(cantidadDevuelta.containsKey(moneda)){
                    cantidadDevuelta.replace(moneda, cantidadDevuelta.get(moneda)+1);
                }else{
                    cantidadDevuelta.put(moneda, 1);
                }
                caja[1][i] = caja[1][i]-1;
                devuelta-=moneda;
            }else{
                i++;
                if(i== caja[0].length && devuelta!=0){
                    throw new RuntimeException("Upps, no alcanza las monedas para devolver");
                }
            }

        }

        return cantidadDevuelta;

    }


}
