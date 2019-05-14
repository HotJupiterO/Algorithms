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
        System.out.println(bst.getValue(bst.root));
        System.out.println("lower = "+ bst.minValue());
        System.out.println("upper = "+ bst.maxValue());


        bst.print();

    }
}
