package com.sda.cw_13;

public class BinarySearchTreeImpl implements BinarySearchTree {
    @Override
    public void add(int element) {


    }

    @Override
    public boolean contains(int element) {
        return false;
    }

    @Override
    public int remove(int remove) {
        return 0;
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
