package dinamica;

import java.util.Arrays;

public class AlgoritmoPrim {
    private static final int V = 5;

    int minClave(int clave[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && clave[v] < min) {
                min = clave[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void imprimirMST(int parent[], int grafo[][]) {
        System.out.println("Arista \tPeso");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + grafo[i][parent[i]]);
        }
    }

    void primMST(int grafo[][]) {
        int parent[] = new int[V];
        int clave[] = new int[V];
        boolean mstSet[] = new boolean[V];

        Arrays.fill(clave, Integer.MAX_VALUE);
        clave[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minClave(clave, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != 0 && !mstSet[v] && grafo[u][v] < clave[v]) {
                    parent[v] = u;
                    clave[v] = grafo[u][v];
                }
            }
        }
        imprimirMST(parent, grafo);
    }

    public static void main(String[] args) {
        AlgoritmoPrim t = new AlgoritmoPrim();
        int grafo[][] = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        t.primMST(grafo);
    }
}
