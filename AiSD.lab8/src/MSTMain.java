public class MSTMain {
    public static void main(String[] args) {
        int[][] graph = new int[][]
                {       {0, 10, 50, 30, 10},     //  0
                        {10, 0, 30, 10, 0},     //  1
                        {50, 30, 0, 20, 40},     //  2
                        {30, 10, 20, 0, 0},     //  3
                        {10, 0,  40, 0, 0}};     //  4

        /*int[][] graph = new int[][]
                {       {0,4,3,0,0,0 },     //  0
                        {4,0,1,2,0,0 },     //  1
                        {3,1,0,4,0,0},     //  2
                        {0,2,4,0,2,0},     //  3
                        {0,0,0,2,0,6},
                        {0,0,0,0,6,0}};*/
                    //   0  1  2  3  4  5
        MST t = new MST(graph.length);

        t.primMST(graph);
    }
}
