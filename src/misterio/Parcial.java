package misterio;

import java.util.Arrays;

public class Parcial {


    public static void main(String[] args) {
        Parcial parcial = new Parcial();
        int[][] matrix = parcial.misterio(3,2);
        for(int[] fila:matrix){
            System.out.println(Arrays.toString(fila));
        }
    }

    public int[][] misterio (int n, int k){
        int[][] memo = new int [n+1][k+1];
        for (int i = 0; i <= n; i++) { //i=1
            for (int j = 0; j <= Math.min (i, k); j++) { //0<=1
                    calcular(memo, i, j);
            }
        }

        return memo;
    }

    private int calcular(int[][] memo, int i, int j){

        if(j==0){
            return memo[i][j]=3*i;
        }else if(j==i){
            return memo[i][j] = (int) Math.pow(i, j);
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j] = calcular(memo, i-1, j-1) + 4 * calcular(memo, i, j-1);

        return memo[i][j];
    }
}
