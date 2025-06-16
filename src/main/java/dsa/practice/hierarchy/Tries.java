package dsa.practice.hierarchy;

import java.util.HashMap;
import java.util.Map;

public class Tries {

    private Node root = new Node();

    public void addWord(String word) {
        Node currentNode = root;
        for (char character : word.toCharArray()) {
            if (currentNode.children.containsKey(character)) {
                currentNode = currentNode.children.get(character);
            } else {
                Node node = new Node();
                currentNode.children.put(character, node);
                currentNode = node;
            }
        }
        currentNode.isCompleteWord = true;
    }

    public boolean isCompleteWord(String word) {
        Node currentNode = root;
        for (char character : word.toCharArray()) {
            if (currentNode.children.containsKey(character)) {
                currentNode = currentNode.children.get(character);
            } else {
                return false;
            }
        }
        return currentNode.isCompleteWord;
    }

    private class Node {
        private Map<Character, Node> children = new HashMap<>();
        private boolean isCompleteWord = false;
    }
}
