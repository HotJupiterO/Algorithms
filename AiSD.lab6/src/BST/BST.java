package BST;
class Node {
    int value, height;
    Node right, left;

    Node(int value) {
        this.value = value;
        this.height = 1;
        this.right = null;
        this.left = null;
    }


}
public class BST {
    Node root;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node parrent = null, current = root;
        parrent = current;
        while (true) {
            if (value == current.value) {
                return;
            }
            if (value < current.value) {
                current = current.left;
                if (current == null) {
                    parrent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parrent.right = newNode;
                    return;
                }
            }
        }




    }


    int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

}
