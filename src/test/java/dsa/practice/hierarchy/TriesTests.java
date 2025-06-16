package dsa.practice.hierarchy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriesTests {

    Tries tries;

    @BeforeEach
    void setUp() {
        tries = new Tries();
    }

    @Test
    void testAddAndFindSingleWord() {
        tries.addWord("apple");
        assertTrue(tries.isCompleteWord("apple"));
    }

    @Test
    void testPrefixIsNotCompleteWord() {
        tries.addWord("apple");
        assertFalse(tries.isCompleteWord("app"));
    }

    @Test
    void testSimilarWords() {
        tries.addWord("car");
        tries.addWord("cart");
        tries.addWord("care");

        assertTrue(tries.isCompleteWord("car"));
        assertTrue(tries.isCompleteWord("cart"));
        assertTrue(tries.isCompleteWord("care"));

        assertFalse(tries.isCompleteWord("ca"));
        assertFalse(tries.isCompleteWord("cars"));
    }

    @Test
    void testEmptyString() {
        tries.addWord("");
        assertTrue(tries.isCompleteWord(""));
    }

    @Test
    void testCaseSensitivity() {
        tries.addWord("Hello");
        assertTrue(tries.isCompleteWord("Hello"));

        assertFalse(tries.isCompleteWord("hello"));
    }

    @Test
    void testNonExistingWord() {
        tries.addWord("test");
        assertFalse(tries.isCompleteWord("testing"));
        assertFalse(tries.isCompleteWord("tes"));
    }

    @Test
    void testMultipleWords() {
        String[] words = {"dog", "deer", "deal", "dodge", "cat", "car", "cars"};
        for (String word : words) {
            tries.addWord(word);
        }

        for (String word : words) {
            assertTrue(tries.isCompleteWord(word));
        }

        assertFalse(tries.isCompleteWord("do"));
        assertFalse(tries.isCompleteWord("de"));
    }
}
