package dsa.practice.hierarchy;

public class BinarySearchTree {
    
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }
        return root.contains(value);
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        if (root.contains(value)) {
            root = root.delete(value);
        }
    }

    public void printInOrder() {
        if (root == null) {
            return;
        }
        root.printInOrder();
    }

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (value <= this.value) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (value == this.value) {
                return true;
            } else if (value < this.value) {
                if (left == null) {
                    return false;
                }
                return left.contains(value);
            } else {
                if (right == null) {
                    return false;
                }
                return right.contains(value);
            }
        }

        public Node delete(int value) {
            if (value < this.value) {
                left = left.delete(value);
            } else if (value > this.value) {
                right = right.delete(value);
            } else {
                // value == this.value
                if (left == null) {
                    return right;
                }
                if (right == null) {
                    return left;
                }
                // have two children
                Node current = right;
                while(current.left != null) {
                    current = current.left;
                }
                this.value = current.value;
                right = right.delete(current.value);
            }
            return this;
        }

        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.printf("%d ", this.value);
            if (right != null) {
                right.printInOrder();
            }
        }
    }
}
