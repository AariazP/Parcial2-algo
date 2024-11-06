package dinamica;

import java.util.Arrays;

public class Factorial {


    public static void main(String[] args) {

        Factorial factorial = new Factorial();
        System.out.println(Arrays.toString(factorial.factorial(10)));

    }

    //memorización si va hacia arriba
    public int[] factorial(int i){

        if(i==0) return new int[]{0};

        int[] factorial = new int[i];
        int aux = 1;

        for(int j=1; j<=i; j++){

            factorial[j-1] = aux*j;
            aux*=j;

        }

        return factorial;
    }

    
}
