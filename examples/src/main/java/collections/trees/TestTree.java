package collections.trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestTree<E> {

    private Node<E> root;
    private int size;

    public void add(E value){

        if (value == null)
            throw new IllegalArgumentException("Must not be null");

        if (root == null){
            root = new Node<>(value);
            size++;
            return;
        }

        add(value, root);

    }

    public boolean contains(E value) {
        if (value == null)
            return false;
        return contains(value, root);
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    private boolean contains(E value, Node<E> node) {
        if (node == null) {
            return false;
        }

        Comparable<E> comp = (Comparable<E>) value;

        int cmp = comp.compareTo(node.value);

        if (cmp == 0) {
            return true;
        } else if (cmp > 0) {
            return contains(value, node.right);
        } else {
            return contains(value, node.left);
        }

    }

    @SuppressWarnings("unchecked")
    private void add(E val, Node<E> node) {

        Comparable<E> comp = (Comparable<E>) val;

        int cmp = comp.compareTo(node.value);

        if ( cmp > 0) {

            if (node.right == null) {
                node.right = new Node<>(val, node);
                size++;
                return;
            }

            //Recursively adding element to the right branch
            add(val, node.right);

        } else if (cmp < 0) {

            if (node.left == null){
                node.left = new Node<>(val, node);
                size++;
                return;
            }

            //Recursively adding element to the left branch
            add(val, node.left);
        }

    }

    private Node<E> rotateLeft(Node<E> node) {

        //Link to parent
        Node<E> tmp = node.right;

        //Left child of parent now right child of grand parent
        node.right = tmp.left;
        tmp.left.parent = node;

        //Grand parent now left child of parent
        tmp.left = node;

        tmp.parent = node.parent;
        node.parent = tmp;

        return tmp;
    }

    private Node<E> rotateRight(Node<E> node) {

        //Link to parent
        Node<E> tmp = node.left;

        //Right child of parent now left child of grand parent
        node.left = tmp.right;
        tmp.right.parent = node;

        //Grand parent now right child of parent
        tmp.right = node;

        tmp.parent = node.parent;
        node.parent = tmp;

        return tmp;
    }


    public void printTree() {
        visit(root);
    }

    private void visit(Node<E> node) {
        if (node == null){
            return;
        }
        visit(node.left);

        System.out.println(node.value);

        visit(node.right);
    }

    public Iterator<E> iterator() {

        return new InOrderTreeIterator<>(root);

    }

    private static class InOrderTreeIterator<E> implements Iterator<E> {

        private Node<E> next;

        InOrderTreeIterator(Node<E> first) {
            next = first;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {

            Node<E> node = next;

            if (node == null){
                throw new NoSuchElementException();
            }

            next = successor(node);

            return node.value;

        }

        private Node<E> successor(Node<E> node) {

            if (node.right != null) {

                Node<E> leftmost = node.right;

                while (leftmost.left != null) {
                    leftmost = leftmost.left;
                }
                return leftmost;

            } else {

                Node<E> parent = node.parent;
                Node<E> child = node;

                while (parent != null && child == parent.right) {
                    child = parent;
                    parent = parent.parent;
                }

                return parent;
            }
        }
    }


    private static class Node<E>{

        E value;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }

        Node(E value, Node<E> parent) {
            this.value = value;
            this.parent = parent;
        }

    }

}
