package BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree bst;

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
    void insertTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(12);
        assertEquals(12, binarySearchTree.getValue(binarySearchTree.root));
    }

    @Test
    void deleteTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.delete(7);
        assertEquals(10, binarySearchTree.getValue(binarySearchTree.root));
    }

    @Test
    void minValueTest() {
        assertEquals(3, bst.minValue());
    }

    @Test
    void maxValueTest() {
        assertEquals(12, bst.maxValue());
    }
}