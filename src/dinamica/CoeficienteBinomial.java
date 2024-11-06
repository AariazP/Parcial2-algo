package dinamica;

import java.util.Arrays;

public class CoeficienteBinomial {

    public static void main(String[] args) {
        CoeficienteBinomial cb = new CoeficienteBinomial();
        long[][] matrix = cb.calcularCoeficientes(7);

        for(long[] filas:matrix){
            System.out.println(Arrays.toString(filas));
            System.out.println();
        }
    }

    private long[][] calcularCoeficientes(int n) {

        long[][] coeficientes = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            coeficientes[i][0] = 1;
            coeficientes[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                coeficientes[i][j] = coeficientes[i - 1][j - 1] + coeficientes[i - 1][j];
            }
        }
        return coeficientes;
    }


}
