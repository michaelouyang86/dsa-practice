package dsa.problems.tree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/implement-trie-prefix-tree
public class TrieOriginal {

    private Node root;

    public TrieOriginal() {
        root = new Node();
    }

    public void insert(String word) {
        Node currentNode = root;
        for (char character : word.toCharArray()) {
            currentNode = currentNode.addChild(character);
        }
        currentNode.isEnd = true;
    }
    
    public boolean search(String word) {
        Node currentNode = root;
        for (char character : word.toCharArray()) {
            Node child = currentNode.getChild(character);
            if (child != null) {
                currentNode = child;
            } else {
                return false;
            }
        }
        return currentNode.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node currentNode = root;
        for (char character : prefix.toCharArray()) {
            Node child = currentNode.getChild(character);
            if (child != null) {
                currentNode = child;
            } else {
                return false;
            }
        }
        return true;
    }

    private static class Node {
        private Map<Character, Node> children = new HashMap<>();
        private boolean isEnd = false;

        private Node addChild(char character) {
            if (children.containsKey(character)) {
                return children.get(character);
            } else {
                Node child = new Node();
                children.put(character, child);
                return child;
            }
        }

        private Node getChild(char character) {
            return children.get(character);
        }
    }
}
