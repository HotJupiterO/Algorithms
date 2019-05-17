package BST;

public class PostOrder implements Visitor{
    @Override
    public void visit(BinarySearchTree bst) {
        printPostorder(bst.root);
    }


     void printPostorder(BinarySearchTree.Node node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.value + " ");
    }

}
