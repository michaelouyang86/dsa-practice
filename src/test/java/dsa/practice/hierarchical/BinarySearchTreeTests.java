package dsa.practice.hierarchical;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTests {

    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    void testInsertAndContains() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(7));
        assertTrue(bst.contains(15));
        assertTrue(bst.contains(12));
        assertTrue(bst.contains(18));
        assertFalse(bst.contains(0));
        assertFalse(bst.contains(20));
    }

    @Test
    void testPrintInOrder() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.printInOrder();

        System.setOut(System.out);
        String expected = "3 5 7 10 12 15 18 ";
        assertEquals(expected, outContent.toString());
    }

    @Test
    void testDeleteLeafNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3); // Leaf node

        bst.delete(3);
        assertFalse(bst.contains(3));
    }

    @Test
    void testDeleteNodeWithOneChild() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12); // 15 has one left child

        bst.delete(15);
        assertFalse(bst.contains(15));
        assertTrue(bst.contains(12));
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        bst.insert(18);

        bst.delete(15);
        assertFalse(bst.contains(15));
        assertTrue(bst.contains(12));
        assertTrue(bst.contains(18));
    }

    @Test
    void testDeleteRoot() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.delete(10);
        assertFalse(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
    }

    @Test
    void testDeleteNonExistentValue() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.delete(99); // Does not exist
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
    }

    @Test
    void testDeleteAllNodes() {
        int[] values = {10, 5, 15, 3, 7, 12, 18};
        for (int val : values) {
            bst.insert(val);
        }

        for (int val : values) {
            bst.delete(val);
            assertFalse(bst.contains(val));
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bst.printInOrder();
        System.setOut(System.out);
        assertEquals("", outContent.toString()); // Empty tree
    }
}
