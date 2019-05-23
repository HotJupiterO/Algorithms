package BST;

public class BinarySearchTree implements Element {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    class Node {
        int value;
        Node left, right;
        private Node parentHelper;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
            parentHelper = this;
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
        Node deletedNode = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) return node;

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) return node.left;
            node.value = minValue(node.right);
            node.right = delete(node.right, node.value);
        }
        return node;
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

    private Node search(Node root, int key) {

        if (root == null || root.value == key) {
            return root;
        }

        if (root.value > key) {
            root.left.parentHelper = root;
            return search(root.left, key);
        } else {
            root.right.parentHelper = root;
            return search(root.right, key);
        }

    }

    public int upper(int value) {
        Node current;
        if ((current = search(this.root, value)) == null && current.parentHelper.value < value) {
            return Integer.MIN_VALUE;
        } else if (current.parentHelper.value > value) return current.parentHelper.value;
        if ((current.right) == null) {
            return current.parentHelper.value;
        }
        current = current.right;
        if (current.left == null) return current.value;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int lower(int value) {
        Node current;
        current = search(this.root, value);
        if (value < this.root.value) {
            if (current.parentHelper.value > value
                    && current.left == null) {
                return current.value;
            } else if (current.parentHelper.value < value) return current.parentHelper.value;
            current = current.left;
            if (current.right == null) return current.value;
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        } else {
            if (current.parentHelper.value > value
                    && current.left == null) {
                return this.root.value;
            } else if (current.parentHelper.value < value) return current.parentHelper.value;
            current = current.left;
            if (current.right == null) return current.value;
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        }


    }

    /*public Node get2ndLargestNode() {
        return get2ndLargestNode(root, root);
    }

    private Node get2ndLargestNode(Node current, Node prev) {
        if (current == null) {
            return null;
        }

        if (current.right == null) {
            return prev;
        }

        return get2ndLargestNode(current.right, current);
    }*/
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
