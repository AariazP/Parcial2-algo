package dinamica;

import java.util.Arrays;

public class Fibonacci {


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(Arrays.toString(fibonacci.getFibo(150)));

    }

    public long[] getFibo(int n){

        if(n<=1) return new long[]{1};
        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 1;
        for(int j=2; j<n; j++){
            long siguiente = arr[j-1] + arr[j-2];
            arr[j] = siguiente;
        }
        return arr;
    }

}
