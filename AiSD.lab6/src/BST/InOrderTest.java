package BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InOrderTest {
    BinarySearchTree bst;
    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(10);
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(12);
    }

    @Test
    void printInorder() {
    }
}