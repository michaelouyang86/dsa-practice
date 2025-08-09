package dsa.problems.tree;

// https://leetcode.com/problems/implement-trie-prefix-tree
public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node currentNode = root;
        for (char c : word.toCharArray()) {
            currentNode = currentNode.addChild(c);
        }
        currentNode.isEnd = true;
    }
    
    public boolean search(String word) {
        Node currentNode = root;
        for (char c : word.toCharArray()) {
            Node child = currentNode.getChild(c);
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
        for (char c : prefix.toCharArray()) {
            Node child = currentNode.getChild(c);
            if (child != null) {
                currentNode = child;
            } else {
                return false;
            }
        }
        return true;
    }

    private static class Node {

        private Node[] children = new Node[26];
        private boolean isEnd;

        private Node addChild(char c) {
            if (children[c - 'a'] != null) {
                return children[c - 'a'];
            } else {
                Node node = new Node();
                children[c - 'a'] = node;
                return node;
            }
        }

        private Node getChild(char c) {
            return children[c - 'a'];
        }
    }
}
