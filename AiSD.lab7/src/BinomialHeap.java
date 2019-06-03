

public class BinomialHeap {
    Node head;
    int size;

    BinomialHeap() {
        head = null;
        size = 0;
    }

    public void makeEmpty() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insert(int value) {
        if (value > 0) {
            Node tmp = new Node(value);
            if (head == null) {
                head = tmp;
                size = 1;
            } else {
                union(tmp);
                size++;
            }
        }
    }

    public int minimum() {
        return head.findMinNode().key;
    }


    public int extractMin() {
        if (head == null)
            return Integer.MAX_VALUE;

        Node temp = head, prevTemp = null;
        Node minNode = head.findMinNode();

        while (temp.key != minNode.key) {
            prevTemp = temp;
            temp = temp.sibling;
        }

        if (prevTemp == null) {
            head = temp.sibling;
        } else {
            prevTemp.sibling = temp.sibling;
        }

        temp = temp.child;
        Node fakeNode = temp;

        while (temp != null) {
            temp.parent = null;
            temp = temp.sibling;
        }

        if ((head == null) && (fakeNode == null)) {
            size = 0;
        } else {
            if ((head == null) && (fakeNode != null)) {
                head = fakeNode.reverse(null);
                size = head.getSize();
            } else {
                if ((head != null) && (fakeNode == null)) {
                    size = head.getSize();
                } else {
                    union(fakeNode.reverse(null));
                    size = head.getSize();
                }
            }
        }
        return minNode.key;
    }

    private void union(Node heap) {
        merge(heap);
        Node prevTemp = null, tmp = head, nextTemp = head.sibling;

        while (nextTemp != null) {
            if ((tmp.degree != nextTemp.degree) || ((nextTemp.sibling != null)
                    && (nextTemp.sibling.degree == tmp.degree))) {
                prevTemp = tmp;
                tmp = nextTemp;
            } else {
                if (tmp.key <= nextTemp.key) {
                    tmp.sibling = nextTemp.sibling;
                    nextTemp.parent = tmp;
                    nextTemp.sibling = tmp.child;
                    tmp.child = nextTemp;
                    tmp.degree++;
                } else {
                    if (prevTemp == null) {
                        head = nextTemp;
                    } else {
                        prevTemp.sibling = nextTemp;
                    }
                    tmp.parent = nextTemp;
                    tmp.sibling = nextTemp.child;
                    nextTemp.child = tmp;
                    nextTemp.degree++;
                    tmp = nextTemp;
                }
            }
            nextTemp = tmp.sibling;
        }
    }


    public void decreaseKey(int oldVal, int newVal) {
        Node temp = head.findNode(oldVal);
        if (temp == null)
            return;
        temp.key = newVal;
        Node tempParent = temp.parent;

        while ((tempParent != null) && (temp.key < tempParent.key)) {
            int z = temp.key;
            temp.key = tempParent.key;
            tempParent.key = z;

            temp = tempParent;
            tempParent = tempParent.parent;
        }
    }

    public void delete(int key) {
        if ((head != null) && (head.findNode(key) != null)) {
            decreaseKey(key, minimum() - 1);
            extractMin();
        }
    }


    private void merge(Node heap) {
        Node temp1 = head;
        Node temp2 = heap;

        while ((temp1 != null) && (temp2 != null)) {
            if (temp1.degree == temp2.degree) {
                Node tmp = temp2;
                temp2 = temp2.sibling;
                tmp.sibling = temp1.sibling;
                temp1.sibling = tmp;
                temp1 = tmp.sibling;
            } else {
                if (temp1.degree < temp2.degree) {
                    if ((temp1.sibling == null) || (temp1.sibling.degree > temp2.degree)) {
                        Node tmp = temp2;
                        temp2 = temp2.sibling;
                        tmp.sibling = temp1.sibling;
                        temp1.sibling = tmp;
                        temp1 = tmp.sibling;
                    } else {
                        temp1 = temp1.sibling;
                    }
                } else {
                    Node tmp = temp1;
                    temp1 = temp2;
                    temp2 = temp2.sibling;
                    temp1.sibling = tmp;
                    if (tmp == head) {
                        head = temp1;
                    }
                }
            }
        }
        if (temp1 == null) {
            temp1 = head;
            while (temp1.sibling != null) {
                temp1 = temp1.sibling;
            }
            temp1.sibling = temp2;
        } else {

        }
    }

    public void displayHeap() {
        System.out.print("\nHeap : ");
        displayHeap(head);
        System.out.println("\n");
    }

    private void displayHeap(Node r) {
        if (r != null) {
            displayHeap(r.child);
            System.out.print(r.key + " ");
            displayHeap(r.sibling);
        }
    }

    /*
     *         1. Insert    +
     *         2. Minimum   +
     *         3. Extract-min   +
     *         4. Union     +
     *         5. Decrease-key  +
     *         6. Delete    +
     *
     *
     * */
}

class Node {
    Node sibling, parent, child;
    int key, degree;

    Node(int k) {
        sibling = null;
        parent = null;
        child = null;
        key = k;
        degree = 0;
    }

    public Node findMinNode() {
        Node a = this;
        Node b = this;
        int min = a.key;

        while (a != null) {
            if (a.key < min) {
                b = a;
                min = a.key;
            }
            a = a.sibling;
        }
        return b;
    }

    public Node findNode(int key) {
        Node tmp = this, node = null;
        while (tmp != null) {
            if (tmp.key == key) {
                node = tmp;
                break;
            }
            if (tmp.child == null) {
                tmp = tmp.sibling;
            } else {
                node = tmp.child.findNode(key);
                if (node == null) {
                    tmp = tmp.sibling;
                } else break;
            }
        }
        return node;
    }

    public Node reverse(Node sib) {
        Node node;
        if (sibling != null) {
            node = sibling.reverse(this);
        } else node = this;
        sibling = sib;
        return node;
    }

    public int getSize() {
//        return (1 + ((child == null) ? 0 : child.getSize()) + ((sibling == null) ? 0 : sibling.getSize()));
        int ret = 0;
        int tmp = 0;
        if (child == null) return 1;
        if (sibling == null) return 1 + child.getSize();
        return 1 + child.getSize() + sibling.getSize();
    }
}














