package misterio;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MinValueInfiniteMatrix {
    private static final int INFINITO = Integer.MAX_VALUE;
    private static final int SEARCH_LIMIT = 1_000_000;

    // Memorización: almacena valores ya calculados para ciertas posiciones
    private Map<String, Integer> memoizationMap = new HashMap<>();
    private Random random = new Random();

    // Método principal para buscar el valor mínimo aproximado
    public int findMinValue() {
        int minValue = INFINITO;
        int minRow = -1, minCol = -1;

        for (int i = 0; i < SEARCH_LIMIT; i++) {
            // Generar posiciones aleatorias en la matriz infinita
            int row = random.nextInt(INFINITO);
            int col = random.nextInt(INFINITO);

            // Obtener el valor en la posición generada
            int value = getMatrixValue(row, col);

            // Actualizar el mínimo si encontramos un valor menor
            if (value < minValue) {
                minValue = value;
                minRow = row;
                minCol = col;
            }
        }

        // Mostrar la posición del valor mínimo encontrado
        System.out.println("Menor valor aproximado encontrado: " + minValue +
                " en posición (" + minRow + ", " + minCol + ")");
        return minValue;
    }

    // Simula el cálculo de un valor en una posición de la matriz infinita
    private int getMatrixValue(int row, int col) {
        String key = row + "," + col;

        // Usar memorización para evitar recálculos
        if (memoizationMap.containsKey(key)) {
            return memoizationMap.get(key);
        }

        // Calcular un valor simulado para la posición dada (puede cambiarse según el caso)
        int value = random.nextInt(1000);  // Aquí puedes definir el rango de valores en la matriz

        // Almacenar el valor calculado en la memorización
        memoizationMap.put(key, value);

        return value;
    }

    public static void main(String[] args) {
        MinValueInfiniteMatrix finder = new MinValueInfiniteMatrix();
        int minValue = finder.findMinValue();
        System.out.println("Valor mínimo aproximado encontrado en la matriz infinita: " + minValue);
        new Random().nextInt();
    }
}
