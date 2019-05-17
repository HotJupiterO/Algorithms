package BST;

public class InOrder implements Visitor {
    @Override
    public void visit(BinarySearchTree bst) {
        printInorder(bst.root);
    }

     void printInorder(BinarySearchTree.Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

}
