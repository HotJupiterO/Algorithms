import java.util.Arrays;

public class Graph {
    Edge[] edge;
    int vertice, edges;

    Graph(int v, int e) {
        this.vertice = v;
        this.edges = e;
        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    class subset {
        int parent, rank;
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST() {
        Edge result[] = new Edge[vertice];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertice; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset subsets[] = new subset[vertice];
        for (i = 0; i < vertice; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < vertice; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < vertice - 1) {
            Edge nextEdge = new Edge();
            nextEdge = edge[i++];

            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);

            if (x != y) {
                result[e++] = nextEdge;
                Union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in " +
                "the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].source + " -- " +
                    result[i].destination + " == " + result[i].weight);
    }

}


class Edge implements Comparable<Edge> {
    int source, destination, weight;

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}