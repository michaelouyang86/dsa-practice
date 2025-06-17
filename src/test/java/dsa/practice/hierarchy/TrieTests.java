package dsa.practice.hierarchy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrieTests {

    Trie trie;

    @BeforeEach
    void setUp() {
        trie = new Trie();
    }

    @Test
    void testAddAndFindSingleWord() {
        trie.addWord("apple");
        assertTrue(trie.isCompleteWord("apple"));
    }

    @Test
    void testPrefixIsNotCompleteWord() {
        trie.addWord("apple");
        assertFalse(trie.isCompleteWord("app"));
    }

    @Test
    void testSimilarWords() {
        trie.addWord("car");
        trie.addWord("cart");
        trie.addWord("care");

        assertTrue(trie.isCompleteWord("car"));
        assertTrue(trie.isCompleteWord("cart"));
        assertTrue(trie.isCompleteWord("care"));

        assertFalse(trie.isCompleteWord("ca"));
        assertFalse(trie.isCompleteWord("cars"));
    }

    @Test
    void testEmptyString() {
        trie.addWord("");
        assertTrue(trie.isCompleteWord(""));
    }

    @Test
    void testCaseSensitivity() {
        trie.addWord("Hello");
        assertTrue(trie.isCompleteWord("Hello"));

        assertFalse(trie.isCompleteWord("hello"));
    }

    @Test
    void testNonExistingWord() {
        trie.addWord("test");
        assertFalse(trie.isCompleteWord("testing"));
        assertFalse(trie.isCompleteWord("tes"));
    }

    @Test
    void testMultipleWords() {
        String[] words = {"dog", "deer", "deal", "dodge", "cat", "car", "cars"};
        for (String word : words) {
            trie.addWord(word);
        }

        for (String word : words) {
            assertTrue(trie.isCompleteWord(word));
        }

        assertFalse(trie.isCompleteWord("do"));
        assertFalse(trie.isCompleteWord("de"));
    }
}
