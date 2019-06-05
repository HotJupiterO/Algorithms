public class MST {
    private int vertices;

    /**
     * @param v vertices
     */
    MST(int v) {
        this.vertices = v;
    }

    private int getMin(int[] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < vertices; i++)
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        return minIndex;
    }

    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public void primMST(int[][] graph) {
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        Boolean[] mstSet = new Boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < vertices - 1; i++) {
            int u = getMin(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0
                        && !mstSet[v]
                        && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }
}
