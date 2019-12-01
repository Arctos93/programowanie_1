package com.sda.cw_13;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private Node root;

    @Override
    public void add(int element) {
        if (isEmpty()) {
            addToEmpty(element);
        } else {
            addToNotEmpty(element);
        }
    }

    private void addToNotEmpty(int element) {
        Node parent = findParentFor(element);
        addNodeToParent(parent, element);
    }

    private Node findParentFor(int element) {
        Node current = root;

        while (element <= current.getValue() && current.hasLeft() ||
                element > current.getValue() && current.hasRight()) {
            if (element <= current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return current;
    }

    private void addNodeToParent(Node parent, int element) {
        Node node = new Node(parent, element);
        if (element <= parent.getValue()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
    }

    private void addToEmpty(int element) {
        root = new Node(null, element);
    }

    @Override
    public boolean contains(int element) {
       return contains_r(element);
    }

    private boolean contains_r(int element) {
        return nodeContains(root, element);
    }

    private boolean nodeContains(Node node, int element) {
        if (node == null) {
            return false;
        } else if (node.getValue() == element) {
            return true;
        } else if (element < node.getValue()) {
            return nodeContains(node.getLeft(), element);
        } else {
            return nodeContains(node.getRight(), element);
        }
    }

    private boolean contains_i(int element) {
        if(isEmpty()) {
            return false;
        } else {
            Node current = root;
            while (true) {
                if(element == current.getValue()) {
                    return true;
                } else if (element < current.getValue() && current.hasLeft()) {
                    current = current.getLeft();
                } else if (element > current.getValue() && current.hasRight()) {
                    current = current.getRight();
                } else {
                    return false;
                }
            }
        }
    }

    @Override
    public int remove(int remove) {
        return 0;
    }

    private boolean isEmpty() {
        return root == null;
    }

    private class Node {
        private Node parent;
        private Node left;
        private Node right;
        private int value;

        public Node(Node parent, int value) {
            this.parent = parent;
            this.value = value;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }
    }

}
