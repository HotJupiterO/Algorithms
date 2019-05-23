package BST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(10);
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(12);
//        bst.delete(7);
//        bst.delete(12);
//        bst.delete(3);
//        bst.delete(7);
        /*System.out.println(bst.getValue(bst.root));
        System.out.println("lower = " + bst.minValue());
        System.out.println("upper = " + bst.maxValue());*/
        int upper = 8;
        int lower = 3;
        System.out.println(upper + " => upper: " + bst.upper(upper));
        System.out.println(lower + " => lower: " + bst.lower(lower));


        traversalsChooser(bst);
//        postOrder.visit(bst);


//        bst.print();

    }

    private static void traversalsChooser(BinarySearchTree bst) {
        Scanner sc = new Scanner(System.in);
        String param = "";
        System.out.println("Type: \n1. \"pre\" for Preorder" +
                "\n2. \"post\" for Postorder" +
                "\n3. \"in\" for Inorder");
        while (!param.equals("exit")) {
            param = sc.next().toLowerCase();
            if (param.equals("pre")) {
                bst.accept(new PreOrder());
                System.out.println();
            }
            if (param.equals("in")) {
                bst.accept(new InOrder());
                System.out.println();
            }
            if (param.equals("post")) {
                bst.accept(new PostOrder());
                System.out.println();
            }
        }
    }
}


