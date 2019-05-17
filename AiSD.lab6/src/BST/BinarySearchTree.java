package BST;

import org.jetbrains.annotations.NotNull;

public class BinarySearchTree implements Element {
    Node root;
    BinarySearchTree() {
        root = null;
    }

    class Node {
        int value;
        Node left, right;
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        Node parrent = null;
        while (true) {
            parrent = current;
            if (value == current.value) {
                return;
            }
            if (value < current.value) {
                current = current.left;
                if (current == null) {
                    parrent.left = node;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parrent.right = node;
                    return;
                }
            }
        }
    }

    public void delete(int value) {
        _delete(root, value);
    }

    private Node _delete(Node root, int value) {
        if (root == null) return root;

        if (value < root.value) {
            root.left = _delete(root.left, value);
        } else if (value > root.value) {
            root.right = _delete(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) return root.left;
            root.value = minValue(root.right);
            root.right = _delete(root.right, root.value);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    private int maxValue(Node root) {
        int maxValue = root.value;
        while (root.left != null) {
            maxValue = root.right.value;
            root = root.right;
        }
        return maxValue;
    }
    public int maxValue() {
        return maxValue(root);
    }
    public int minValue() {
        return minValue(root);
    }

    /*
    private void printPreorder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    private void printPostorder(Node node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.value + " ");
    }

    private void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

    private void printPreorder() {printPreorder(root);}

    private void printInorder() {printInorder(root);}

    private void printPostorder() {printPostorder(root);}

    public void print() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type: \n1. \"pre\" for Preorder" +
                "\n2. \"post\" for Postorder" +
                "\n3. \"in\" for Inorder");
        String param = sc.next().toLowerCase();
        if (param.equals("pre")) {
            printPreorder();
        }
        if (param.equals("in")) {
            printInorder();
        }
        if (param.equals("post")) {
            printPostorder();
        }
    }
*/

     int getValue(Node node) {
        return node.value;
    }

}
