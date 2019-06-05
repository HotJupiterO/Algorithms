public class Main {
    public static void main(String[] args) {


        int V = 6;
        int E = 7;
        Graph graph = new Graph(V, E);


        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 4;


        graph.edge[1].source = 1;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 1;


        graph.edge[2].source = 0;
        graph.edge[2].destination = 2;
        graph.edge[2].weight = 3;


        graph.edge[3].source = 2;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 4;


        graph.edge[4].source = 3;
        graph.edge[4].destination = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].source = 4;
        graph.edge[5].destination = 5;
        graph.edge[5].weight = 6;


        graph.edge[6].source = 1;
        graph.edge[6].destination = 3;
        graph.edge[6].weight = 2;


        graph.KruskalMST();
    }
}

