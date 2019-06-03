package BST;

public class PreOrder implements Visitor {
    @Override
    public void visit(BinarySearchTree bst) {
        printPreorder(bst.root);
    }

    private void printPreorder(BinarySearchTree.Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

}
